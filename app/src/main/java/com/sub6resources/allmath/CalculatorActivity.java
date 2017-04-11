package com.sub6resources.allmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }
    String equationString = "0";


    public void clickZero(View view) {
        addNumberToEquation("0");
    }
    public void clickOne(View view) {
        addNumberToEquation("1");
    }
    public void clickTwo(View view) {
        addNumberToEquation("2");
    }
    public void clickThree(View view) {
        addNumberToEquation("3");
    }
    public void clickFour(View view) {
        addNumberToEquation("4");
    }
    public void clickFive(View view) {
        addNumberToEquation("5");
    }
    public void clickSix(View view) {
        addNumberToEquation("6");
    }
    public void clickSeven(View view) {
        addNumberToEquation("7");
    }
    public void clickEight(View view) {
        addNumberToEquation("8");
    }
    public void clickNine(View view) {
        addNumberToEquation("9");
    }

    public void addNumberToEquation(String number) {
        if(equationString == "0") {
            equationString = number;
        }
        else {
            equationString += number;
        }
        updateOutput();
    }
    public void updateOutput() {
        TextView output = (TextView)findViewById(R.id.outputText);
        output.setText(equationString);

    }
}
