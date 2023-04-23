package com.example.calculator;

import static android.provider.Settings.System.getString;

import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {
    private int num1;
    private int num2;
    private String result;
    private String operator;
    private String default_output = "Empty output";

    public void setNum1(int input1) {
        num1 = input1;
    }

    public void setNum2(int input2) {
        num2 = input2;
    }

    public void setOperator(String opera) {
        operator = opera;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getOperator(String default_operator) {
        if (operator == null){
            return default_operator;
        }
        return operator;
    }

    public String getResult(String default_result) {
        if (result == null){
            return default_result;
        }
        return result;
    }

    public CalculatorViewModel() {
        // trigger user load.
    }

    void doCalculation() {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
        result = addFromJNI(num1, num2);
    }

    /**
     * Native methods that is implemented by the 'calculator' native library,
     * which is packaged with this application.
     */
    public native String addFromJNI(int a, int b);
}

