package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNum1;
    private TextView textViewResult;
    private String operator;
    private double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.Num1);
        textViewResult = findViewById(R.id.Result);

        setNumberButtonClickListeners();
        setOperatorButtonClickListeners();
        setEqualButtonClickListener();
        setClearButtonClickListener();
    }

    private void setNumberButtonClickListeners() {
        int[] numberButtonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
                R.id.btn8, R.id.btn9, R.id.btndot
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                editTextNum1.append(button.getText().toString());
            }
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperatorButtonClickListeners() {
        int[] operatorButtonIds = {
                R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                num1 = Double.parseDouble(editTextNum1.getText().toString());
                operator = button.getText().toString();
                editTextNum1.setText("");
            }
        };

        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setEqualButtonClickListener() {
        findViewById(R.id.btnequal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Double.parseDouble(editTextNum1.getText().toString());
                double result = 0;
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                textViewResult.setText(String.valueOf(result));
                editTextNum1.setText("");
            }
        });
    }

    private void setClearButtonClickListener() {
        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNum1.setText("");
                textViewResult.setText("");
                num1 = 0;
                num2 = 0;
                operator = "";
            }
        });
    }
}
