package com.example.masterproject;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class CalciFragment extends Fragment {


    private EditText display;
    private String currentno = "";
    private String operator = "";
    private double operand1 = 0.0;
    private double operand2 = 0.0;

    public CalciFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calci, container, false);
        display = view.findViewById(R.id.edittext);

        view.findViewById(R.id.btn0).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btn1).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btn2).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btn3).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btn4).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btn5).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btn6).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btn7).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btn8).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btn9).setOnClickListener(this::onButtonClick);

        view.findViewById(R.id.btnminus).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btnplus).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btnmul).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btndiv).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btnmod).setOnClickListener(this::onButtonClick);


        view.findViewById(R.id.back).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btnans).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.off).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.btndot).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.reset).setOnClickListener(this::onButtonClick);
        view.findViewById(R.id.ac).setOnClickListener(this::onButtonClick);

        return view;
    }

    private  void onButtonClick(View view){
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText){
            case "AC":
                clear();
                break;

            case "Ans":
                calculate();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                setOperator(buttonText);
                break;
            default:
                appendNumber(buttonText);
                break;
        }
    }

    private void clear(){
        currentno = "";
        operand1 = 0.0;
        operand2 = 0.0;
        operator = "";
        display.setText("0");
    }

    private  void setOperator(String op){
        operator = op;
        operand1 = Double.parseDouble(currentno);
        currentno = "";
    }

    private void appendNumber(String Number){
        if(currentno.equals("0")){
            currentno = Number;
        }else {
            currentno += Number;
        }
        display.setText(currentno);
    }

    private  void appendDecimal(){
        if(!currentno.contains(".")){
            currentno += ".";
            display.setText(currentno);
        }
    }

    private void  calculate(){

        operand2 = Double.parseDouble(currentno);

        double result;

        switch (operator){

            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand2 != 0 ? operand1/operand2 : Double.NaN;
                break;
            case "%":
                result = operand1 % operand2;
                break;
            default:
                result = 0.0;
                break;
        }

        display.setText(String.valueOf(result));
        currentno = String.valueOf(result);
    }
}