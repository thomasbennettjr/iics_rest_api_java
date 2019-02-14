package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project {
    private String id;
    private String name;
    private String description;


    public Project() {
    }

    public Project(String name, String description)
    {
        this.id = null;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project [id = " + this.getId() + ", name = " + this.getName() +", description = " + this.getDescription() +"]";
    }
}
