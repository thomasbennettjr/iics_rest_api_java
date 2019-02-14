package com.metaopsis.icsapi.helper.v3;

import java.util.Arrays;

public class User {
    private Product[] products;
    private UserInfo userInfo;

    public User() {
    }

    public User(Product[] products, UserInfo userInfo) {
        this.products = products;
        this.userInfo = userInfo;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "products=" + Arrays.toString(products) +
                ", userInfo=" + userInfo +
                '}';
    }



}


