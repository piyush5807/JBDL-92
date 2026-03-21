package com.calci;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Calci {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return Math.abs(a - b);
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int modulo(int a, int b) {
        return a % b;
    }

    public int power(int a, int b){
        return ((Double)Math.pow(a, b)).intValue();
    }


}