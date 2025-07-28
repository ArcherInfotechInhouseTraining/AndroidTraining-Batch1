package com.example.numerconversion;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

         Spinner spinner = findViewById(R.id.spinner);
        EditText editText = findViewById(R.id.edittext);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.result);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.conversion_option,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(V ->{
            String input = editText.getText().toString();
            String selectoption = spinner.getSelectedItem().toString();

            switch (selectoption){
                case "decimal":
                    int decimal = Integer.parseInt(input);
                    textView.setText("Binary: "+decimalToBinary(decimal)+"\n Octal: "+
                            decimaltoOctal(decimal)+"\n Hexa: "+decimalToHexa(decimal));
                    break;
                case "binary":
                    String binary = input;
                    textView.setText("Decimal: "+binaryToDecimal(binary)+"\n Octal: "+binaryToOctal(binary)
                                            +"\n Hexa: "+binarytoHexa(binary));
                    break;
                case "octal":
                    String octal = input;
                    textView.setText("Binary: "+octalToBinary(octal)+"\n Decimal: "+octalToDecimal(octal)+
                            "\n Hexa: "+octalToHexa(octal));
                    break;
                case "hexa":
                    String hexa = input;
                    textView.setText("Binary: "+hexaToBinary(hexa)+"\n Octal: "+hexaToOctal(hexa)+
                            "\n Decimal: "+hexaToDecimal(hexa));
                    break;
            }
        });
    }

    private String decimalToBinary(int decimal){
        return Integer.toBinaryString(decimal);
    }
    private String decimaltoOctal(int decimal){
        return Integer.toOctalString(decimal);
    }
    private String decimalToHexa(int decimal){
        return Integer.toHexString(decimal).toUpperCase();
    }

    private int binaryToDecimal(String binary){
        return Integer.parseInt(binary,2);
    }

    private String binaryToOctal(String binary){
        int decimal = binaryToDecimal(binary);
        return decimaltoOctal(decimal);
    }

    private String binarytoHexa(String binary){
        int decimal = binaryToDecimal(binary);
        return decimalToHexa(decimal);
    }

    private String octalToBinary(String octal){
        int decimal = Integer.parseInt(octal, 8);
        return decimalToBinary(decimal);
    }

    private String octalToDecimal(String octal){
        return String.valueOf(Integer.parseInt(octal,8));
    }

    private String octalToHexa(String octal){
        int decimal = Integer.parseInt(octalToDecimal(octal));
        return Integer.toHexString(decimal).toUpperCase();
    }

    private String hexaToBinary(String hexa){
        int decimal = Integer.parseInt(hexa, 16);
        return decimalToBinary(decimal);
    }

    private int hexaToDecimal(String hexa){
        return Integer.parseInt(hexa, 16);
    }

    private String hexaToOctal(String hexa){
        int decimal = hexaToDecimal(hexa);
        return decimaltoOctal(decimal);
    }
}