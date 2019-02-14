package com.metaopsis.icsapi.helper;

/**
 * Created by tbennett on 11/5/16.
 */
public class Roles {
    private String name;
    private String description;

    public Roles() {
    }

    public Roles(String name, String description) {
        this.name = name;
        this.description = description;
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
        return "Roles{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
