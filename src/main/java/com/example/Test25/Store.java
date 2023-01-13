package com.example.Test25;

import org.springframework.beans.factory.annotation.*;

public class Store {
    @Autowired
    @Qualifier("title")
    String name;
}
