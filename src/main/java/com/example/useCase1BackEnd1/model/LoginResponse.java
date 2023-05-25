package com.example.useCase1BackEnd1.model;

public class LoginResponse {

    String message;
    Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LoginResponse(String message) {
        super();
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
}
