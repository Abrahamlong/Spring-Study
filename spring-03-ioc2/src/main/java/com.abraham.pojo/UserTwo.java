package com.abraham.pojo;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/7
 */
public class UserTwo {
    private String name;

        public UserTwo() {
            System.out.println("UserTwo被创建了！");
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name = " + name);
    }
}
