package com.abraham.demo01;

/**
 * @author long
 * @date 2020/9/9
 */
// 代理角色
public class Proxy {
    private Host host;

    public Proxy() {

    }

    public Proxy(Host host) {
        this.host = host;
    }

    // 代理房东租房
    public void rent(){
        seeHouse();
        host.rent();
        fare();
    }

    // 中介看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    // 收中介费
    public void fare(){
        System.out.println("中介要收中介费");
    }
}
