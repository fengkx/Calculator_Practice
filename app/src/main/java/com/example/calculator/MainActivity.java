package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculator.expr.Expression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String inputText;
    private Button outputBtn;
    private TextView resultTag;
    private TextView inputTextBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.outputBtn = findViewById(R.id.nbtnEq);
        this.inputTextBox = findViewById(R.id.inputBox);
        this.inputText = "";

        findViewById(R.id.nbtn0).setOnClickListener(this);
        findViewById(R.id.nbtn1).setOnClickListener(this);
        findViewById(R.id.nbtn2).setOnClickListener(this);
        findViewById(R.id.nbtn3).setOnClickListener(this);
        findViewById(R.id.nbtn4).setOnClickListener(this);
        findViewById(R.id.nbtn5).setOnClickListener(this);
        findViewById(R.id.nbtn6).setOnClickListener(this);
        findViewById(R.id.nbtn7).setOnClickListener(this);
        findViewById(R.id.nbtn8).setOnClickListener(this);
        findViewById(R.id.nbtn9).setOnClickListener(this);
        findViewById(R.id.nbtnAdd).setOnClickListener(this);
        findViewById(R.id.nbtnSub).setOnClickListener(this);
        findViewById(R.id.nbtnMul).setOnClickListener(this);
        findViewById(R.id.nbtnDiv).setOnClickListener(this);
        findViewById(R.id.nbtnDel).setOnClickListener(this);
        findViewById(R.id.nbtnDot).setOnClickListener(this);
        findViewById(R.id.nbtnEq).setOnClickListener(this);
        findViewById(R.id.nbtnDel).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                inputText = "";
                inputTextBox.setText("");
                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nbtn0:
                inputText += "0";
                break;
            case R.id.nbtn1:
                inputText += "1";
                break;
            case R.id.nbtn2:
                inputText += "2";
                break;
            case R.id.nbtn3:
                inputText += "3";
                break;
            case R.id.nbtn4:
                inputText += "4";
                break;
            case R.id.nbtn5:
                inputText += "5";
                break;
            case R.id.nbtn6:
                inputText += "6";
                break;
            case R.id.nbtn7:
                inputText += "7";
                break;
            case R.id.nbtn8:
                inputText += "8";
                break;
            case R.id.nbtn9:
                inputText += "9";
                break;
            case R.id.nbtnAdd:
                inputText += "+";
                break;
            case R.id.nbtnSub:
                inputText += "-";
                break;
            case R.id.nbtnMul:
                inputText += "*";
                break;
            case R.id.nbtnDiv:
                inputText += "/";
                break;
            case R.id.nbtnDel:
                int len = inputText.length();
                if(len > 0) {
                    inputText = inputText.substring(0, inputText.length()-1);
                }
                break;
            case R.id.nbtnDot:
                inputText += ".";
                break;
            case R.id.nbtnEq:
                Expression expr = new Expression(inputText);
                inputText = expr.value().val.toString();
                break;
            default:
                break;
        }
        inputTextBox.setText(escapeStr());
    }

    private String escapeStr() {
        return inputText.replace("*", "×").replace("/", "÷");
    }
}
