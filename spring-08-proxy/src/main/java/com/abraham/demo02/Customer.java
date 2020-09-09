package com.abraham.demo02;

/**
 * @author long
 * @date 2020/9/9
 */
public class Customer {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
//        userService.delete();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.delete();
    }
}
