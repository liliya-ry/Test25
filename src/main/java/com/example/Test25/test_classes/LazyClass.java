package com.example.Test25.test_classes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyClass {
    @Override
    public String toString() {
        return "I am lazy class";
    }
}
