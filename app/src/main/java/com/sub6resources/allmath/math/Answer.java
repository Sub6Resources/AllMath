package com.sub6resources.allmath.math;

/**
 * Created by 59485 on 4/17/2017.
 */

public class Answer {
    private String answer;
    private Errors error;
    public enum Errors {Success, NoCode};
    public Answer(String _answer) {
        answer = _answer;
        error = Errors.Success;
    }
    public Answer(String errorMessage, Errors _error) {
        answer = errorMessage;
        error = _error;
    }
    public String getErrorMessage() {
        return this.answer;
    }
    public String getAnswer() {
        return this.answer;
    }
    public Errors getError() {
        return this.error;
    }
    public String toString() {
        return answer+","+error.toString();
    }
}
