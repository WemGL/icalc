package com.wembleyleach;

public class Calculator {

    public float calculate(float firstOperand, float secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "x":
                return firstOperand * secondOperand;
            case "÷":
                if(secondOperand == 0)
                    return 0;
                return firstOperand / secondOperand;
            default:
                return 0;
        }
    }

    public float negate(float value) {
        if(value == 0) return 0;
        return value * -1;
    }

    public float convertToPercentage(float value) {
        if(value == 0) return 0;
        return value / 100;
    }

}
