package com.abraham.demo03;

/**
 * @author long
 * @date 2020/9/9
 */
public class Client {
    public static void main(String[] args) {
        // 真实角色
        Host host = new Host();

        // 代理角色
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        // 通过调用程序处理角色处理我们要调用的接口对象
        proxyInvocationHandler.setRent(host);
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();  // 这里的proxy就是动态生成的代理类

        proxy.rent();

    }
}
