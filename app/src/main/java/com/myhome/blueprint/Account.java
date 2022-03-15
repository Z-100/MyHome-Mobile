package com.myhome.blueprint;

import lombok.Getter;
import lombok.Setter;

/**
 * Please lombok... please just work with kotlin
 * I really really miss you
 */
@Getter
@Setter
public class Account {

    private String email;
    private String password;
    private String token;

    public Account(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }
}
