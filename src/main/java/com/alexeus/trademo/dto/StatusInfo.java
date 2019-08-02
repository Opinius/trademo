package com.alexeus.trademo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.PrintWriter;
import java.io.StringWriter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusInfo {
    private boolean success = true;
    private String message;
    private String stackTrace;

    public StatusInfo() {
    }

    public StatusInfo(String errorText) {
        this.success = false;
        this.message = errorText;
    }

    public StatusInfo(Throwable error) {
        this.success = false;
        this.message = error.getMessage();
        StringWriter sw = new StringWriter();
        error.printStackTrace(new PrintWriter(sw));
        this.stackTrace = sw.toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public StatusInfo withStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
        return this;
    }
}
