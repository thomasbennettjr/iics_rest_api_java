package com.metaopsis.icsapi.helper.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

public class object {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;
    private String path;
    private String type;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String description;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String updateTime;

    public object() {
    }

    public object(String path, String type)
    {
        this.path = path;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "object{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}