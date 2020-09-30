package com.abraham.demo04;

import com.abraham.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author long
 * @date 2020/9/9
 */
// 该类会自动生成我们需要的代理类！（相当于工具类）
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 该方法生成得到代理类
     *  this.getClass().getClassLoader()：为了加载到类在哪个位置；
     *  rent.getClass().getInterfaces()：表示该方法要代理的接口是哪个；
     *  this:代表该类自己的InvocationHandler（因为该类是实现的InvocationHandler接口，故直接返回该类本身就好）
     * @return 返回生成的代理类
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    // 处理代理实例，并返回结果（真正执行的方法）
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        //动态代理的本质，就是使用反射机制实现！
        Object result = method.invoke(target, args);
        return result;
    }

    public void log(String msg){
        System.out.println("[Debug] 执行了" + msg + "方法");
    }

}
