package com.example.useCase1BackEnd1.model;

public class LoginResponse {

    private String message;

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
}
