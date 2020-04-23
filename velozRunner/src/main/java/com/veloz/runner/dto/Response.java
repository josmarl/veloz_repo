package com.veloz.runner.dto;

public class Response {
    private Boolean success = new Boolean(false);
    private String message;

    public Response() {
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
