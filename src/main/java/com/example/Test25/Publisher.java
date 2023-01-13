package com.example.Test25;

import org.springframework.beans.factory.annotation.Autowired;

public class Publisher {
    String name;
    Address address;
    Store store;

    @Autowired
    public void setStore(Store store) {
        this.store = store;
    }
}
