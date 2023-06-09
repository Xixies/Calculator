package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'calculator' library on application startup.
    static {
        System.loadLibrary("calculator");
    }

    private ActivityMainBinding binding;

    private TextView tv_operator;
    private TextView tv_output;
    private EditText et_num1;
    private EditText et_num2;
    private Button bt_add;
    private Button bt_minus;
    private Button bt_multiply;
    private Button bt_divide;
    private Button bt_cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tv_operator = binding.textviewOperator;
        tv_output = binding.sampleText;
        et_num1 = binding.edittextInput1;
        et_num2 = binding.edittextInput2;
        bt_add = binding.buttonAdd;
        bt_minus = binding.buttonMinus;
        bt_multiply = binding.buttonMultiply;
        bt_divide = binding.buttonDivide;
        bt_cal = binding.buttonCalculate;

        // local variable stored in ViewModel
        CalculatorViewModel viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);
        bt_cal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String num_s1 = String.valueOf(et_num1.getText());
                String num_s2 = String.valueOf(et_num2.getText());
                if (num_s1.isEmpty() || num_s2.isEmpty()){ // empty input
                    tv_output.setText(getString(R.string.default_output));
                    return;
                }
                viewModel.setNum1(Integer.parseInt(num_s1));
                viewModel.setNum2(Integer.parseInt(num_s2));
                viewModel.doCalculation();
                tv_output.setText(viewModel.getResult(getString(R.string.default_output)));
            }
        });

        bt_add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tv_operator.setText(getString(R.string.operator_add));
                viewModel.setOperator(CalculatorViewModel.Operator.ADD);
            }
        });

        bt_minus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tv_operator.setText(getString(R.string.operator_minus));
                viewModel.setOperator(CalculatorViewModel.Operator.MINUS);
            }
        });

        bt_multiply.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tv_operator.setText(getString(R.string.operator_multiply));
                viewModel.setOperator(CalculatorViewModel.Operator.MULTIPLY);
            }
        });

        bt_divide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tv_operator.setText(getString(R.string.operator_divide));
                viewModel.setOperator(CalculatorViewModel.Operator.DIVIDE);
            }
        });

        // reset data when activity recreate
        tv_output.setText(viewModel.getResult(getString(R.string.default_output)));
        CalculatorViewModel.Operator operator = viewModel.getOperator();
        if (operator == CalculatorViewModel.Operator.ADD) {
            tv_operator.setText(getString(R.string.operator_add));
        } else if(operator == CalculatorViewModel.Operator.MINUS) {
            tv_operator.setText(getString(R.string.operator_minus));
        } else if(operator == CalculatorViewModel.Operator.MULTIPLY) {
            tv_operator.setText(getString(R.string.operator_multiply));
        } else if(operator == CalculatorViewModel.Operator.DIVIDE){
            tv_operator.setText(getString(R.string.operator_divide));
        } else{
            tv_operator.setText(getString(R.string.default_operator));
        }

    }
}