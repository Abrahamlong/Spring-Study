package com.abraham.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author long
 * @date 2020/9/8
 */
public class People {
    @Resource(name = "cat1")   // 该注解为java的原生注解，与@Autowired注解的功能相同
//    @Autowired  // 在属性上使用@Autowired注解
    private Cat cat;
    @Autowired
//    @Qualifier(value = "dog2")
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

//    @Autowired  // 在set方法上使用@Autowired注解
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
