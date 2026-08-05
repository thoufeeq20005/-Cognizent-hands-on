package com.example;

public class Calculator {

    public int add(int a,int b){
        return a+b;
    }

    public int subtract(int a,int b){
        return a-b;
    }

    public boolean isPositive(int n){
        return n>0;
    }

    public String getMessage(){
        return "Hello";
    }

    public String getNullValue(){
        return null;
    }
}