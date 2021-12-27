package com.sbrf.reboot;

public class Calculator {

    public double getAddition(double a, double b) {
        return a + b;
    }

    public double getSubtraction(double a, double b) {
        return a - b;
    }

    public double getMultiplication(double a, double b) {
        return a * b;
    }

    public double getDivision(double a, double b) {
        return a / b;
    }

    public double getLog(double a) {
        return Math.log(a);
    }

    public double getExp(double a){
        return Math.exp(a);
    }

    public double getPow(double a, double b) {
        return Math.pow(a,b);
    }

}
