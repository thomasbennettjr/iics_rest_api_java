package com.metaopsis.icsapi.helper;

/**
 * Created by tbennett on 11/7/16.
 */
public class AgentConfigs {
    private String name;
    private String type;
    private String subType;
    private String value;
    private boolean customized;
    private boolean overriden;
    private String defaultValue;
    private String platform;

    public AgentConfigs() {
    }

    public AgentConfigs(String name, String type, String subType, String value, boolean customized, boolean overriden, String defaultValue, String platform) {
        this.name = name;
        this.type = type;
        this.subType = subType;
        this.value = value;
        this.customized = customized;
        this.overriden = overriden;
        this.defaultValue = defaultValue;
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCustomized() {
        return customized;
    }

    public void setCustomized(boolean customized) {
        this.customized = customized;
    }

    public boolean isOverriden() {
        return overriden;
    }

    public void setOverriden(boolean overriden) {
        this.overriden = overriden;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "AgentConfigs{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                ", value='" + value + '\'' +
                ", customized=" + customized +
                ", overriden=" + overriden +
                ", defaultValue='" + defaultValue + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
