package com.calci;

//import lombok.Getter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//@Getter
public class Calci {

    public static void main(String[] args) {
        System.out.println("Hello World from Calci");
    }

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