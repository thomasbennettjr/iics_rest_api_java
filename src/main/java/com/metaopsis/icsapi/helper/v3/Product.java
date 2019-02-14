package com.metaopsis.icsapi.helper.v3;

public class Product {
    private String name;
    private String baseApiUrl;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseApiUrl() {
        return baseApiUrl;
    }

    public void setBaseApiUrl(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", baseApiUrl='" + baseApiUrl + '\'' +
                '}';
    }
}