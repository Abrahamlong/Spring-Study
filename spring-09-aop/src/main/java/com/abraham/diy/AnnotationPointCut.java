package com.abraham.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author long
 * @Date 2020/9/9
 */
// 使用注解方式实现AOP
@Aspect // 该注解标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.abraham.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("==========|| 方法执行前 ||==========");
    }

    @After("execution(* com.abraham.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("==========|| 方法执行后 ||==========");
    }

    // 在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.abraham.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint pjp){
        System.out.println("========环绕前========");

        // 获得签名,返回被执行的方法名称
        Signature signature = pjp.getSignature();
        System.out.println("  " + signature);

        // 执行方法
        try {
            Object proceed = pjp.proceed();
//            System.out.println("###" + proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("========环绕后========");
    }
}
