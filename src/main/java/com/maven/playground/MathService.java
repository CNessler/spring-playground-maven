package com.maven.playground;

/**
 * Created by Claire on 4/29/17.
 */
public class MathService {
    String operation;
    int firstNumber;
    int secondNumber;

    public String getOperation() {
        return operation;
    }

    public MathService setOperation(String operation) {
        this.operation = operation;
        return this;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public MathService setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
        return this;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public MathService setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
        return this;
    }

    protected String calculate() {
        String returnValue = "";
        if ("add".equals(getOperation())) {
            returnValue = String.valueOf(getFirstNumber()) + " + " + String.valueOf(getSecondNumber()) + " = " + String.valueOf(getFirstNumber() + getSecondNumber());
        } else if ("subtract".equals(getOperation())) {
            returnValue = String.valueOf(getFirstNumber()) + " - " + String.valueOf(getSecondNumber()) + " = " + String.valueOf(getFirstNumber() - getSecondNumber());
        } else if ("multiply".equals(getOperation())) {
            returnValue = String.valueOf(getFirstNumber()) + " * " + String.valueOf(getSecondNumber()) + " = " + String.valueOf(getFirstNumber() * getSecondNumber());
        } else if ("divide".equals(getOperation())) {
            returnValue = String.valueOf(getFirstNumber()) + " / " + String.valueOf(getSecondNumber()) + " = " + String.valueOf(getFirstNumber()/getSecondNumber());
        }
        return returnValue;
    }

    protected String getVolume(int length, int width, int height) {
        int total = length * width * height;
        return "The volume of a "+ length + "x" + width + "x" + height + " rectangle is " + String.valueOf(total);
    }

    protected String getSum(String[] queryString) {
        String sumOutput = "";
        int totalValue=0;
        for (int i=0;i<queryString.length;i++) {
            sumOutput += queryString[i];
            if (i != queryString.length-1) {
                sumOutput += " + ";
            }
            totalValue += Integer.parseInt(queryString[i]);
        }
        return String.format("%s = %s", sumOutput, String.valueOf(totalValue));
    }
}
