package com.example.calculator;

import static android.provider.Settings.System.getString;

import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {
    private int num1;
    private int num2;
    private String result;
    public enum Operator {NULL, ADD, MINUS, MULTIPLY, DIVIDE};
    private Operator operator;

    public void setNum1(int input1) {
        num1 = input1;
    }

    public void setNum2(int input2) {
        num2 = input2;
    }

    public void setOperator(Operator opera) {
        operator = opera;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getResult(String default_result) {
        if (result == null){
            return default_result;
        }
        return result;
    }

    /**
     * Processing Arithmetic calculations by calling native library.
     */
    void doCalculation() {
        switch (operator){
            case ADD:
                result = addFromJNI(num1, num2);
                break;
            case MINUS:
                result = minusFromJNI(num1, num2);
                break;
            case MULTIPLY:
                result = multiplyFromJNI(num1, num2);
                break;
            case DIVIDE:
                result = divideFromJNI(num1, num2);
                break;
            case NULL:
                result = null;
                break;
        }
    }

    /**
     * Native methods that is implemented by the 'calculator' native library,
     * which is packaged with this application.
     */
    public native String addFromJNI(int a, int b);
    public native String minusFromJNI(int a, int b);
    public native String multiplyFromJNI(int a, int b);
    public native String divideFromJNI(int a, int b);
}

