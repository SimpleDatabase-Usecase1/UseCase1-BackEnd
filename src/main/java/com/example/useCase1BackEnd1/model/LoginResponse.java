package com.example.useCase1BackEnd1.model;

public class LoginResponse {

    String username;
    String message;
    String keyword;
    Boolean status;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public LoginResponse(String username, String message, String keyword, Boolean status) {
        this.username = username;
        this.message = message;
        this.keyword = keyword;
        this.status = status;
    }

}
