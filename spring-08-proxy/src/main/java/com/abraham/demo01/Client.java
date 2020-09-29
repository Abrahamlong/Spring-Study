package com.abraham.demo01;

/**
 * @author long
 * @date 2020/9/9
 */
// 租客
public class Client {
    public static void main(String[] args) {
        // 房东要出租房子
        Host host = new Host();
//        host.rent();
        // 代理，中介帮房东出租房子，但是中介一般会有一些其他的附属属性
        Proxy proxy = new Proxy(host);
        // 客户不要面对房东，直接找中介租房
        proxy.rent();
    }
}
