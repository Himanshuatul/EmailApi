package com.email.model;

public class EmailResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public EmailResponse(String token) {
        this.token = token;
    }
}
