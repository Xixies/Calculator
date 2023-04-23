package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        EditText et1 = binding.edittextInput1;
        EditText et2 = binding.edittextInput2;
        Button bt_cal = binding.buttonCalculate;

        // local variable stored in ViewModel
        CalculatorViewModel viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        bt_cal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                viewModel.setNum1(Integer.parseInt(String.valueOf(et1.getText())));
                viewModel.setNum2(Integer.parseInt(String.valueOf(et2.getText())));
                viewModel.doCalculation();
                String res = viewModel.getResult();
                tv.setText(res);
            }
        });

        tv.setText(viewModel.getResult());
    }
}