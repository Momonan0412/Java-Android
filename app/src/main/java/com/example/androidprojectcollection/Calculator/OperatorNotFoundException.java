package com.example.androidprojectcollection.Calculator;

public class OperatorNotFoundException extends Exception{
    public OperatorNotFoundException() {
        super("Operator not found");
    }
}
