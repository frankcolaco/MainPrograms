package com.examples;
public class ExceptionDescriptionExtraction {
}


class TulipsException{
    private String body;
    private int exceptionCode;
    private String exceptionType;
    private String exceptionDescription;
    private Error errors;
    private String errorCode;

    public TulipsException(int code, String type, String description) {
        this.exceptionCode = code;
        this.exceptionType = type;
        this.exceptionDescription = description;
    }

    public TulipsException(int code, String type, String description, Error errors) {
        this.exceptionCode = code;
        this.exceptionType = type;
        this.exceptionDescription = description;
        this.errors = errors;
    }

    public TulipsException(String status, int code, String type, String description) {
        this.body = status;
        this.exceptionCode = code;
        this.exceptionType = type;
        this.exceptionDescription = description;
    }

    public TulipsException(int code, String type, String errorCode, String description) {
        this.exceptionCode = code;
        this.exceptionType = type;
        this.errorCode = errorCode;
        this.exceptionDescription = description;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public String getExceptionDescription() {
        return exceptionDescription;
    }

    public Error getErrors() {
        return errors;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getErrorCode() {
        return errorCode;
    }


    @Override
    public String toString() {
        return "TulipsException{" +
                "body='" + body + '\'' +
                ", exceptionCode=" + exceptionCode +
                ", exceptionType='" + exceptionType + '\'' +
                ", exceptionDescription='" + exceptionDescription + '\'' +
                ", errors=" + errors +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}