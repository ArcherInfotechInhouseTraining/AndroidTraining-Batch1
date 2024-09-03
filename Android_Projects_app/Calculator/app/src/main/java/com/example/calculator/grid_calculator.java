package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class grid_calculator extends AppCompatActivity {


    private EditText display;
    private String currentNumber="";
    private String operator="";
    private double operand1=0.0;
    private double operand2=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_calculator);

        display=findViewById(R.id.ansedittext);

        findViewById(R.id.bt0).setOnClickListener(this::onButtonClick);
        findViewById(R.id.bt1).setOnClickListener(this::onButtonClick);
        findViewById(R.id.bt2).setOnClickListener(this::onButtonClick);
        findViewById(R.id.bt3).setOnClickListener(this::onButtonClick);
        findViewById(R.id.bt4).setOnClickListener(this::onButtonClick);
        findViewById(R.id.bt5).setOnClickListener(this::onButtonClick);
        findViewById(R.id.bt6).setOnClickListener(this::onButtonClick);
        findViewById(R.id.bt7).setOnClickListener(this::onButtonClick);
        findViewById(R.id.bt8).setOnClickListener(this::onButtonClick);
        findViewById(R.id.bt9).setOnClickListener(this::onButtonClick);
        findViewById(R.id.btadd).setOnClickListener(this::onButtonClick);
        findViewById(R.id.btsub).setOnClickListener(this::onButtonClick);
        findViewById(R.id.btmul).setOnClickListener(this::onButtonClick);
        findViewById(R.id.btdiv).setOnClickListener(this::onButtonClick);
        findViewById(R.id.btmod).setOnClickListener(this::onButtonClick);
        findViewById(R.id.btdot).setOnClickListener(this::onButtonClick);

        findViewById(R.id.btans).setOnClickListener(this::onButtonClick);
        findViewById(R.id.reset).setOnClickListener(this::onButtonClick);
        findViewById(R.id.onoff).setOnClickListener(this::onButtonClick);
        findViewById(R.id.backspace).setOnClickListener(this::onButtonClick);
        findViewById(R.id.ac).setOnClickListener(this::onButtonClick);
    }

    private void onButtonClick(View view){
        Button button =(Button) view;
        String buttonText = button.getText().toString();

        switch(buttonText){
            case "AC":
                clear();
                break;

            case "ans":
                calculate();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                setOperator(buttonText);
                break;
            case ".":
                appendDecimal();
                break;
            default:
                appendNumber(buttonText);
                break;
        }
    }
    private void clear(){
        currentNumber="";
        operand1=0.0;
        operand2=0.0;
        operator="";
        display.setText("0");
    }
    private void setOperator(String op){
        operator=op;
        operand1=Double.parseDouble(currentNumber);
        currentNumber="";
    }
    private void appendNumber(String number){
        if(currentNumber.equals("0")){
            currentNumber=number;
        }
        else {
            currentNumber+=number;
        }
        display.setText(currentNumber);
    }

    private void appendDecimal(){
        if(!currentNumber.contains(".")){
            currentNumber+=".";
            display.setText(currentNumber);
        }
    }

    private void calculate(){
        operand2 = Double.parseDouble(currentNumber);

        double result;
        switch (operator)
        {
            case "+":
                result = operand1+operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1*operand2;
                break;
            case "/":
                result = operand2 != 0 ? operand1/operand2 : Double.NaN;
                break;
            default:
                result= 0.0;
                break;
        }
        display.setText(String.valueOf(result));
        currentNumber = String.valueOf(result);
    }
}