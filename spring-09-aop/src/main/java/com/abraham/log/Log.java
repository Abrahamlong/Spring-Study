package com.abraham.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author long
 * @Date 2020/9/9
 */
public class Log implements MethodBeforeAdvice {

    // method：要执行的目标对象的方法
    // objects/args：参数
    // o/target：目标对象
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "的" + method.getName() + "被执行了！");

    }
}
