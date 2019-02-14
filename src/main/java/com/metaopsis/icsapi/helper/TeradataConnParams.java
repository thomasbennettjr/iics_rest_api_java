package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tombennett on 8/15/17.
 */
public class TeradataConnParams implements ToolKitConnectionParameters
{

    @JsonProperty("Password")
    private String password;

    public TeradataConnParams()
    {
    }

    public TeradataConnParams(String password)
    {
        this.password = password;
    }


    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "TeradataConnParams{" +
                ", password='" + password + '\'' +
                '}';
    }
}
