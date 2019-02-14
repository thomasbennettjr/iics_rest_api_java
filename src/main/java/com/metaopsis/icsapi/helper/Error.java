package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tbennett on 11/5/16.
 */
public class Error {

    @JsonProperty("@type")
    private String type;
    private String code;
    private String description;
    private int statusCode;

    public Error() {
    }

    public Error(String type, String code, String description, int statusCode) {
        this.type = type;
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Error{" +
                "type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
