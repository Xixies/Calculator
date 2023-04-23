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
                viewModel.setNum1(Integer.parseInt(String.valueOf(et_num1.getText())));
                viewModel.setNum2(Integer.parseInt(String.valueOf(et_num2.getText())));
                viewModel.doCalculation();
                tv_output.setText(viewModel.getResult(getString(R.string.default_output)));
            }
        });

        bt_add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tv_operator.setText(getString(R.string.operator_add));
                viewModel.setOperator(getString(R.string.operator_add));
            }
        });

        bt_minus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tv_operator.setText(getString(R.string.operator_minus));
                viewModel.setOperator(getString(R.string.operator_minus));
            }
        });

        bt_multiply.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tv_operator.setText(getString(R.string.operator_multiply));
                viewModel.setOperator(getString(R.string.operator_multiply));
            }
        });

        bt_divide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tv_operator.setText(getString(R.string.operator_divide));
                viewModel.setOperator(getString(R.string.operator_divide));
            }
        });

        // reset data when activity recreate
        tv_output.setText(viewModel.getResult(getString(R.string.default_output)));
        tv_operator.setText(viewModel.getOperator(getString(R.string.default_operator)));
    }
}