package org.znz.dto.common;

public class View<T> {
    private Status status;

    private T data;

    public View(T data) {
        this.status = new Status(true, "");
        this.data = data;
    }

    public View(Boolean success, String message) {
        this.status = new Status(success, message);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

class Status {
    private Boolean success;
    private String message;

    public Status(Boolean success, String message) {
        this.success = success;
        this.message = message;
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
