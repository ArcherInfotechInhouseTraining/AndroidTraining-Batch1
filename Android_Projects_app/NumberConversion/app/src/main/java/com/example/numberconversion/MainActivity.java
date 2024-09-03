package com.example.numberconversion;

import static java.lang.Double.toHexString;
import static java.lang.Long.toBinaryString;
import static java.lang.Long.toOctalString;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        EditText editText = findViewById(R.id.edit_text);
        Button button = findViewById(R.id.resultbtn);
        TextView textView = findViewById(R.id.resulttext);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.convertion_option,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(V->{
            String input =editText.getText().toString();
            String selectoption = spinner.getSelectedItem().toString();

            switch (selectoption){
                case "Decimal":{
                    int decimal=Integer.parseInt(input);
                    textView.setText("Binary : "+decimalToBinary(decimal)+"\n"+"Ocatal : "
                            +decimalToOctal(decimal)+"\n"+"hexaDeciaml : "+
                            deciamlToHexdecimal(decimal));
                    break;
                }

                case "Binary" :{
                    String binary=input;
                    textView.setText("Decimal : "+binaryToDecimal(binary)+
                            "\n"+"Octal : "+binaryToOctal(binary)+
                            "\n"+"HexaDeciaml : "+binaryToHexadecimal(binary));
                    break;
                }

                case "Octal":{
                    String octal = input;
                    textView.setText("Binary : "+octalTobinary(octal)+
                            "\n"+"Decimal : "+octalTodecimal(octal)+
                            "\n"+"HexaDecimal : "+octalTohexadecimal(octal));
                    break;
                }

                case "HexaDecimal":{
                    String hexadecimal=input;
                    textView.setText("Binary : "+hexaToBinary(hexadecimal)
                            +"\n"+"Decimal : "+hexaToDecimal(hexadecimal)+
                            "\n"+"Octal : "+hexaToOctal(hexadecimal));
                    break;
                }
            }
        });
    }

    private String decimalToBinary(int decimal){
        return Integer.toBinaryString(decimal);
    }

    private String decimalToOctal(int decimal)
    {
        return Integer.toOctalString(decimal);
    }

    private String deciamlToHexdecimal(int decimal)
    {
        return Integer.toHexString(decimal).toUpperCase(Locale.ROOT);
    }

    private int binaryToDecimal(String binary)
    {
        return Integer.parseInt(binary,2);
    }

    private String binaryToOctal(String binary)
    {
        int decimal = binaryToDecimal(binary);
        return decimalToOctal(decimal);
    }

    private String binaryToHexadecimal(String binary)
    {
        int decimal = binaryToDecimal(binary);
        return deciamlToHexdecimal(decimal).toUpperCase();
    }

    private String octalTobinary(String octal)
    {

        return toBinaryString(Long.parseLong(octal));
    }

    private int octalTodecimal(String octal)
    {

        return Integer.parseInt(octal,8);
    }

    private int octalTohexadecimal(String octal)
    {
        return Integer.parseInt(octal,8);
    }

    private  int hexaToDecimal(String hexa)
    {
        return Integer.parseInt(hexa,16);
    }

    private String hexaToBinary(String hexa)
    {
        int decimal=Integer.parseInt(hexa,16);
        return decimalToBinary(decimal);
    }
    private  String hexaToOctal(String hexa)
    {
        int decimal=Integer.parseInt(hexa,16);
        return decimalToOctal(decimal);
    }
}