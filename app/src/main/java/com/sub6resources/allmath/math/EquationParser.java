package com.sub6resources.allmath.math;

import java.math.BigDecimal;

/**
  Created by Matthew Whitaker on 4/13/2017. Copyright (c) 2017 Sub 6 Resources
 */

public final class EquationParser {
    public static Answer Parse(String equation) {
        //Prepare string
        equation = equation.replaceAll("×", "*");
        equation = equation.replaceAll("÷", "/");
        /*public String PLUS = "+";
        public String MINUS = "-";
        public String TIMES = "×";
        public String DIVIDE = "÷";*/
        BigDecimal result = null;
        Expression expression = new Expression(equation);

        result = expression.eval();
        return new Answer(result.toString());
    }
}
