package com.sub6resources.allmath.math;

/**
 * Created by 59485 on 4/17/2017.
 */

public class Answer {
    private String answer;
    private Expression.ExpressionException error;
    public Answer(String _answer) {
        answer = _answer;
        error = null;
    }
    public Answer(String errorMessage, Expression.ExpressionException _error) {
        answer = errorMessage;
        error = _error;
    }
    public String getErrorMessage() {
        return this.answer;
    }
    public String getAnswer() {
        return this.answer;
    }
    public Expression.ExpressionException getError() {
        return this.error;
    }
    public String getErrorString() {return this.error.getLocalizedMessage();}
    public String toString() {
        return answer+","+error.toString();
    }
}
