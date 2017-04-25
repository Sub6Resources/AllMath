package com.sub6resources.allmath.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
  Created by Matthew Whitaker on 4/13/2017. Copyright (c) 2017 Sub 6 Resources
 */

public final class EquationParser {
    public static Answer Parse(String equation, int precision) {
        //Prepare string
        equation = equation.replaceAll(Symbols.TIMES, "*");
        equation = equation.replaceAll(Symbols.DIVIDE, "/");
        equation = equation.replaceAll(Symbols.PI, "PI");
        equation = equation.replaceAll(Symbols.SUPER_TWO, "^2");
        equation = equation.replaceAll(Symbols.EXCLAMATION, "!0");
        /*public String PLUS = "+";
        public String MINUS = "-";
        public String TIMES = "×";
        public String DIVIDE = "÷";*/
        BigDecimal result = null;
        Expression expression = new Expression(equation).setPrecision(precision);
        expression.addOperator(expression.new Operator("!", 50, true)
        {
            BigDecimal fac(BigDecimal n, BigDecimal acc)
            {
                if (n.equals(BigDecimal.ONE))
                {
                    return acc;
                }
                BigDecimal lessOne = n.subtract(BigDecimal.ONE);
                return fac(lessOne, acc.multiply(lessOne, MathContext.UNLIMITED));
            }

            @Override
            public BigDecimal eval (BigDecimal v1, BigDecimal v2)
            {
                return fac (v1, v1);
            }
        });
        try {
            result = expression.eval();
        } catch(Expression.ExpressionException e) {
            return new Answer("",e);
        } catch(ArithmeticException e) {
            return new Answer("", new Expression.ExpressionException(e.getMessage()));
        }
        return new Answer(result.toString());
    }


    public static BigDecimal Factorial(BigDecimal number) {
        BigDecimal answer = new BigDecimal(0);
        for(BigDecimal i=new BigDecimal(1); i.floatValue() <= number.floatValue(); i.add(new BigDecimal(1))) {
            answer = answer.multiply(i);
        }
        return answer;
    }
}
