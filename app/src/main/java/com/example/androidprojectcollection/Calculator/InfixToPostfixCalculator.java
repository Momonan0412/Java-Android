package com.example.androidprojectcollection.Calculator;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToPostfixCalculator {
    private boolean isOperand(String s) {
        return s.matches("\\d+");
    }
    private int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }
    public ArrayList<String> infixToPostfix(ArrayList<String> infixExpression) {
        ArrayList<String> postfixExpression = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String token : infixExpression) {
            if (isOperand(token)) {
                postfixExpression.add(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfixExpression.add(stack.pop());
                }
                stack.pop(); // Pop the '('
            } else { // Operator
                while (!stack.isEmpty() && getPrecedence(token) <= getPrecedence(stack.peek())) {
                    postfixExpression.add(stack.pop());
                }
                stack.push(token);
            }
        }
        // Pop any remaining operators from the stack
        while (!stack.isEmpty()) {
            postfixExpression.add(stack.pop());
        }
        return postfixExpression;
    }
    public double evaluatePostfix(ArrayList<String> postfixExpression) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfixExpression) {
            if (isOperand(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    case "^":
                        stack.push(Math.pow(operand1, operand2));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }
        return stack.pop();
    }
}

