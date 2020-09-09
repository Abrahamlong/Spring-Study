package com.abraham.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author long
 * @Date 2020/9/9
 */
public class AfterLog implements AfterReturningAdvice {

    // object/returnValue:返回值
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了 " + method.getName() + "方法，返回的结果为：" + returnValue);
    }
}
