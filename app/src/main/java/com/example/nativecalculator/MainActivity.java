package com.example.nativecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String left;
    String right;
    Boolean whichIs = false;
    String operation;

    public void erase(View view) {
        final EditText text = (EditText) findViewById(R.id.editText);
        String content = text.getText().toString();
        if(!whichIs) {
            Integer pos = text.length() - 1;
            content = content.replace(content.substring(pos), "");
            text.setText(content);
            right = content;
            Log.d("VALORES", content);
        } else {
            Integer pos = text.length() - 1;
            content = content.replace(content.substring(pos), "");
            text.setText(content);
            left = content;
            Log.d("VALORES", content);
        }
    }

    public void clear(View view) {
        final EditText text = (EditText) findViewById(R.id.editText);
        text.setText("");
        whichIs = false;
        left = "";
        right = "";
    }

    public void calculate(View view) {
        final EditText text = (EditText) findViewById(R.id.editText);
        Double d = new Double("6.35");
        Double first = d.parseDouble(left);
        Double second = d.parseDouble(right);

        Log.d("VALORES", first + "");
        Log.d("VALORES", second + "");

        if(operation.matches("soma")) {
            Double result = first + second;
            text.setText(result + "");
        } else if(operation.matches("sub")) {
            Double result = second - first;
            text.setText(result + "");
        } else if(operation.matches("mult")) {
            Double result = first * second;
            text.setText(result + "");
        } else {
            Double result = second / first;
            text.setText(result + "");
        }

//        Reset
        whichIs = false;
        left = "";
        right = "";
    }

    public void setOperation (View view) {
        String tag = view.getTag().toString();

        if(tag.matches("soma")) {
            operation = "soma";
        } else if(tag.matches("sub")) {
            operation = "sub";
        } else if(tag.matches("mult")) {
            operation = "mult";
        } else {
            operation = "div";
        }

        whichIs = true;
        final EditText text = (EditText) findViewById(R.id.editText);
        text.setText("");
    }

    public void add_number(View view) {
        final EditText text = (EditText) findViewById(R.id.editText);

        String valorAntigo = text.getText().toString();
        String valorDigitado = view.getTag().toString();

        Log.d("VALORES", valorAntigo);
        Log.d("VALORES", valorDigitado);

        if(whichIs) {
            left = valorAntigo + valorDigitado;
            text.setText(left);
        } else {
            right = valorAntigo + valorDigitado;
            text.setText(right);
        }
    }
}