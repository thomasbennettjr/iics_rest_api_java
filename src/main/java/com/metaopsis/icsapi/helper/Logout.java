package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tbennett on 11/5/16.
 */
public class Logout {

    @JsonProperty("@type")
    private final String type = "logout";
    private String username;
    private String password;

    public Logout() {
    }

    public Logout(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logout{" +
                "type='" + type + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
