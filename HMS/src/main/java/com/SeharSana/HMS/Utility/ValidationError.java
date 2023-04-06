package com.SeharSana.HMS.Utility;

public class ValidationError {
    final String code;
    final String reason;

    public ValidationError(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
