package com.eliteams.quick4j.core.util.responsebeans;

import java.io.Serializable;

public class ResultJson implements Serializable {

    private static final long serialVersionUID = 1L;

    public Boolean success;
    public String message;

    public static ResultJson success() {
        ResultJson result = new ResultJson();
        result.setSuccess(true);
        return result;
    }

    public static ResultJson failure() {
        ResultJson result = new ResultJson();
        result.setSuccess(false);
        return result;
    }

    public static ResultJson failure(String message) {
        ResultJson result = new ResultJson();
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }

    public static ResultJson success(Object data) {
        ResultJsonWithData result = new ResultJsonWithData(data);
        result.setSuccess(true);
        return result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
