package com.sub6resources.allmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.sub6resources.allmath.math.EquationParser;

public class CalculatorActivity extends AppCompatActivity {

    public String PLUS = "+";
    public String MINUS = "-";
    public String TIMES = "×";
    public String DIVIDE = "÷";


    TextView output;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        output = (TextView)findViewById(R.id.outputText);
        answer = (TextView)findViewById(R.id.errorText);
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
    public void clickDel(View view) {
        del();
    }
    public void clickAdd(View view) {
        addSymbolToEquation("+");
    }
    public void clickSubtract(View view) {
        addSymbolToEquation("-");
    }
    public void clickDivide(View view) {
        addSymbolToEquation("÷");
    }
    public void clickMultiply(View view) {
        addSymbolToEquation("×");
    }
    public void clickPeriod(View view) {
        addSymbolToEquation(".");
    }
    public void clickEquals(View view) {
        parseEquation();
    }

    public void addNumberToEquation(String number) {
        if(equationString.equals("0")) {
            equationString = number;
        }
        else {
            equationString += number;
        }
        updateOutput();
    }
    public void addSymbolToEquation(String symbol) {
        //÷  ×  +  -
        if(symbol.equals(PLUS)) {
            if (doesntEndWithNumber(equationString)) {
                del();
                equationString += PLUS;
            } else {
                equationString += PLUS;
            }
        }
        if(symbol.equals(MINUS)) {
            if (doesntEndWithNumber(equationString)) {
                del();
                equationString += MINUS;
            } else {
                equationString += MINUS;
            }
        }
        if(symbol.equals(DIVIDE)) {
            if (doesntEndWithNumber(equationString)) {
                del();
                equationString += DIVIDE;
            } else {
                equationString += DIVIDE;
            }
        }
        if(symbol.equals(TIMES)) {
            if (doesntEndWithNumber(equationString)) {
                del();
                equationString += TIMES;
            } else  {
                equationString += TIMES;
            }
        }
        if(symbol.equals(".")) {
            //TODO we need a more complicated check for a period, since you can only have one per number.
            int periodCount = equationString.length() - equationString.replace(".", "").length();
            int operatorCount = equationString.length() - equationString.replace("+","").replace("-","").replace("×", "").replace("÷","").length();
            if(periodCount < operatorCount+1 && !doesntEndWithNumber(equationString)) {
                if (doesntEndWithNumber(equationString)) {
                    del();
                    equationString += ".";
                } else {
                    equationString += ".";
                }
            }
        }
        updateOutput();
    }
    public void del() {
        if(output.getText().length() > 1) {
            equationString = output.getText().subSequence(0, output.getText().length() - 1).toString();
        } else if(output.getText().length() > 0) {
            equationString = "0";
        }
        output.setText(equationString);
    }
    public void updateOutput() {

        output.setText(equationString);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        while(output.getWidth() > width) {
            output.setTextSize(output.getTextSize()-1);
        }
        if(!doesntEndWithNumber(equationString)) {
            parseEquation();
        }

    }
    public boolean doesntEndWithNumber(String equation) {
        //TODO add other mathematical constants that could be a number
        if (      !equation.endsWith("1")
                &&!equation.endsWith("2")
                &&!equation.endsWith("3")
                &&!equation.endsWith("4")
                &&!equation.endsWith("5")
                &&!equation.endsWith("6")
                &&!equation.endsWith("7")
                &&!equation.endsWith("8")
                &&!equation.endsWith("9")
                &&!equation.endsWith("0")
                &&!equation.endsWith(")")
                ) {
            return true;
        } else {
            return false;
        }
        }
    public void parseEquation() {
        //Parse output in new class
        answer.setText(EquationParser.Parse(equationString).getAnswer());
    }
}
