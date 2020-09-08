package com.abraham.config;

import com.abraham.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author long
 * @date 2020/9/8
 */

@Configuration  // 代表这是一个配置类，和之前学习的bean.xml是一样的
                // 这个注解也会被Spring容器托管，注册到容器中，因为它本来就是一个Component
@ComponentScan("com.abraham.pojo")
@Import(LongConfig2.class)  // 把另外一个配置类导进来可以一起用
public class LongConfig {

    // 注册一个Bean，相当于一个Bean标签，这个方法的名字就是相当于bean标签中的id属性，这个方法的返回值就相当于bean标签中的class属性
    @Bean
    public User user(){ // 方法名等于Bean的id
        return new User();  //返回要注入的bean对象
    }

}
