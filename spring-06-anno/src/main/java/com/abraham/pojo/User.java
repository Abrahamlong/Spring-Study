package com.abraham.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author long
 * @date 2020/9/8
 */

/**
 * @Component 注解等价于在applicationContext.xml文件中注册，即：<bean id="user" class="com.abraham.pojo.User"/>
 * @Component 组件类
 */
@Component
@Scope("singleton") // 标注为单例模式
public class User {

    // 相当于<bean id="user" class="com.abraham.pojo.User">
    //        <property name="name" value="long"/>
    //      </bean>
    @Value("long")
    public String name;

    @Value("abraham")
    public void setName(String name) {
        this.name = name;
    }
}
