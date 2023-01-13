package com.example.Test25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Store {
    @Autowired
    @Qualifier("title")
    String name;
}
