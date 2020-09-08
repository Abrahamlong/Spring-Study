package com.abraham.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author long
 * @date 2020/9/8
 */

@Component
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("long")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
