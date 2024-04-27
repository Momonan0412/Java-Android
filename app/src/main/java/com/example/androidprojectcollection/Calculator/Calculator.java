package com.example.androidprojectcollection.Calculator;

import com.example.androidprojectcollection.MakeToast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator implements MakeToast {
    public Calculator() {}
    public String getResult(ArrayList<String> data){
        InfixToPostfixCalculator infixToPostfixCalculator = new InfixToPostfixCalculator();
        ArrayList<String> postfixExpression = infixToPostfixCalculator.infixToPostfix(data);
        System.out.println("Infix Expression: " + data);
        System.out.println("Postfix Expression: " + postfixExpression);
        double result = infixToPostfixCalculator.evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
        String strResult = result + "";
        if(strResult.endsWith(".0")) strResult = strResult.replace(".0","");
        return strResult;
    }
    public String sequence(String data){
        String res;
        try{
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            res = context.evaluateString(scriptable, data, "JavaScript", 1, null).toString();
            if(res.endsWith(".0")){
                res = res.replace(".0", "");
            }
        } catch (Exception e){
            return "Err";
        }
        return res;
    }
    public String sequentialResult(String data) throws OperatorNotFoundException {
        double num1 = 0;
        double num2 = 0;
        char operator = ' ';
        int i;
        for (i = 0; i < data.length(); i++) {
            char currentChar = data.charAt(i);
            if (isOperator(currentChar)) {
                num1 = Double.parseDouble(data.substring(0, i).trim());
                operator = currentChar;
                int nextOperatorIndex = findNextOperator(data, i + 1);
                num2 = Double.parseDouble(data.substring(i + 1, nextOperatorIndex).trim());
                i = nextOperatorIndex - 1;
                num1 = (num2 != 0) ? getSeqResult(num1, num2, operator) : num1;
            }
        }
        return String.valueOf(num1);
    }

    private int findNextOperator(String data, int startIndex) {
        for (int i = startIndex; i < data.length(); i++) {
            if (isOperator(data.charAt(i))) {
                return i;
            }
        }
        return data.length();
    }

    public boolean isOperator(char operator){
        switch (operator){
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }
    double getSeqResult(double num1, double num2, char op){
        double total = 0;
        if(op == '+'){
            total = num1 + num2;
        } else if (op == '-') {
            total = num1 - num2;
        } else if (op == '*') {
            total = num1 * num2;
        } else if (op == '/') {
            if (num2 != 0) {
                total = num1 / num2;
            } else {
                throw new ArithmeticException();
            }
        }
        return total;
    }

    public List<String> tokenizeExpression(String expression) {
        // Define a pattern to match operators (+, -, *, /)
        Pattern pattern = Pattern.compile("[+\\-*/]");

        // Split the expression based on operators
        Matcher matcher = pattern.matcher(expression);
        List<String> tokens = new ArrayList<>();
        int previousEnd = 0;
        while (matcher.find()) {
            // Add the operand before the operator
            tokens.add(expression.substring(previousEnd, matcher.start()).trim());
            // Add the operator itself
            tokens.add(matcher.group());
            previousEnd = matcher.end();
        }
        // Add the last operand after the last operator
        tokens.add(expression.substring(previousEnd).trim());

        return tokens;
    }
}
