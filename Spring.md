# Spring

### 1. Spring的优点

- Spring是一个开源的免费框架

- Spring是一个轻量级的，非入侵式的框架

- 控制反转（IOC），面向切面编程（AOP)

- 支持事务的处理，对框架整合的支持

  ==总结：Spring是一个轻量级的控制反转（IOC）、面向切面编程（AOP）的框架！==

----

### 2. Spring的组成模块

![image-20200905151744571](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200905151744571.png)

- **核心容器** ：核心容器提供 Spring 框架的基本功能。核心容器的主要组件是 `BeanFactory`，它是工厂模式的实现。 `BeanFactory` 使用 *控制反转* （IOC） 模式将应用程序的配置和依赖性规范与实际的应用程序代码分开。
- **Spring 上下文** ：Spring 上下文是一个配置文件，向 Spring 框架提供上下文信息。Spring 上下文包括企业服务，例如 JNDI、EJB、电子邮件、国际化、校验和调度功能。
- **Spring AOP** ：通过配置管理特性，Spring AOP 模块直接将面向方面的编程功能集成到了 Spring 框架中。所以，可以很容易地使 Spring 框架管理的任何对象支持 AOP。Spring AOP 模块为基于 Spring 的应用程序中的对象提供了事务管理服务。通过使用 Spring AOP，不用依赖 EJB 组件，就可以将声明性事务管理集成到应用程序中。
- **Spring DAO** ：JDBC DAO 抽象层提供了有意义的异常层次结构，可用该结构来管理异常处理和不同数据库供应商抛出的错误消息。异常层次结构简化了错误处理，并且极大地降低了需要编写的异常代码数量（例如打开和关闭连接）。Spring DAO 的面向 JDBC 的异常遵从通用的 DAO 异常层次结构。
- **Spring ORM** ：Spring 框架插入了若干个 ORM 框架，从而提供了 ORM 的对象关系工具，其中包括 JDO、Hibernate 和 iBatis SQL Map。所有这些都遵从 Spring 的通用事务和 DAO 异常层次结构。
- **Spring Web 模块** ：Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文。所以，Spring 框架支持与 Jakarta Struts 的集成。Web 模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作。
- **Spring MVC 框架** ：MVC 框架是一个全功能的构建 Web 应用程序的 MVC 实现。通过策略接口，MVC 框架变成为高度可配置的，MVC 容纳了大量视图技术，其中包括 JSP、Velocity、Tiles、iText 和 POI。

----

### 3. 扩展

> Spring Boot：
>
> ​				一个快速开发的脚手架；
>
> ​				基于SpringBoot开源快速开发当个微服务；
>
> ​				约定大于配置；
>
> ==学习SpringBoot的基础是需要完全掌握Spring以及SpringMVC的基础，如今大多数的公司都是基于SpringBoot进行快速开发的==
>
> Spring Cloud：
>
> ​				SpringCloud是基于SpringBoot实现的；

----

### 4. IOC控制反转

> ==工程1：spring-01-ioc1==

1、UserDao  接口

2、UserDaoImpl  实现类

3、UserService  业务接口

4、UserServiceImpl  业务实现类

  在我们之前的业务中，用户的需求可能会影响我们原来的代码，我们需要根据用户的需求去修改原代码！如果程序代码量十分大，修改一次的成本代价十分高。



我们使用一个Set接口实现，已经发生了革命性的变化

```java
private UserDao userDao;

// 利用set进行动态实现值的注入
public void setUserDao(UserDao userDao) {
    this.userDao = userDao;

```

- 之前，程序是主动创建对象，控制权在程序员手上！
- 使用了set注入之后，程序不再具有主动 性，而是变成了被动的接收对象！

这种思想，从本质上解决了问题，我们程序员不用再去管理对象的创建了。系统的耦合性大大降低了，可以更加专注的在业务的实现上了，这是IOC的原型。



 ==**控制反转IOC** 是一种设计思想，DI（依赖注入）是实现IOC的一种方法 。没有IOC的程序中，我们使用面向对象编程，对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，所谓的控制反转就是：获得依赖对象的方式反转了。==

==IOC是spring的核心内容：==使用了多种方式完美的实现了IOC，可以使用XML配置，也可以使用注解，新版本的Spring也可以零配置实现IOC。

Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从IOC容器中取出需要的对象。

![image-20200907114325773](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200907114325773.png)

**==控制反转是一种通过描述（XML或注解）并通过第三方生产或获取特定对象的方式。在Spring中实现控制反转的是IOC容器，其实现方法是依赖注入（DI）。==**

 XML的配置文件：==工程2：spring-02-hellospring==

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

</beans>
```

----

### 5. IOC创建对象的方式

> ==工程3：spring-03-ioc2==：beans.xml

1、使用无参构造创建对象，默认方法

2、假设我们要使用有参构造创建对象：

​		（1）下标赋值；

```xml
<bean id="user" class="com.abraham.pojo.User">
    <constructor-arg index="0" value="long"/>
</bean>
```

​		（2）类型；

```xml
<bean id="user" class="com.abraham.pojo.User">
    <constructor-arg type="java.lang.String" value="long"/>
</bean>
```

​		（3）直接通过参数名；

```xml
<bean id="user" class="com.abraham.pojo.User">
    <constructor-arg name="name" value="long"/>
</bean>
```

==总结：在配置文件加载的时候，容器中管理的对象就已经初始化了。==

----

### 6. Spring配置

> ==工程3：spring-03-ioc2==：beans.xml

#### 6.1  别名（alias）

 如果添加了别名，我们也可以使用别名来获取到这个对象

```xml
<alias name="user" alias="user2"/>
```

#### 6.2  Bean的配置

```xml
<!--
    id：bean的唯一标识符，也就是相当于我们学的对象名
    class：bean对象所对应的权限定名：包名+类名
    name：别名,而且name可以同时取多个别名,分别可以用空格、逗号、分号进行分割
-->
<bean id="userTwo" class="com.abraham.pojo.UserTwo" name="woshibieming,userTwo2 userTwo3;userTwo4">

</bean>
```

#### 6.3  import

一般用于团队开发使用，它可以将多个配置文件导入合并为一个。

![image-20200907185846469](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200907185846469.png)

假设，现在项目有多个人进行不同的类开发，不同的类需要注册在不同的配置文件beans中，我们可以利用import将所有人的beans文件导入到总的xml文件：applicationContext.xml中，使用的时候直接使用一个总的配置文件就好，如上图所示。如果内容相同则会被合并为一个。

----

### 7. 依赖注入（DI)

> ==工程4：spring-04-di==

#### 7.1  构造器注入

前文已经讲述。

#### 7.2  Set方式注入（重点）

- 依赖注入：

  依赖：bean对象的创建依赖于容器；

  注入：bean对象中的所有属性，由容器来注入。

【环境搭建】

1、复杂类型

```java
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```

2、真实测试对象

```java
public class Student {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbys;
    private Map<String ,String> card;
    private Set<String > games;
    private Properties info;
    private String wife;
}
```

3、applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="address" class="com.abraham.pojo.Address">
        <property name="address" value="福建省龙岩市"/>
    </bean>

    <bean id="student" class="com.abraham.pojo.Student">
        <!--第一种，普通值注入，value-->
        <property name="name" value="long"/>

        <!--第二种，Bean注入，ref-->
        <property name="address" ref="address"/>

        <!--第三种，数组注入，array-->
        <property name="books">
            <array>
                <value>红楼梦</value>
                <value>西游记</value>
                <value>水浒传</value>
            </array>
        </property>

        <!--第四种，List注入-->
        <property name="hobbys">
            <list>
                <value>听歌</value>
                <value>敲代码</value>
                <value>看电影</value>
            </list>
        </property>

        <!--第五种，Map注入-->
        <property name="card">
            <map>
                <entry key="身份证" value="666666"/>
                <entry key="银行卡" value="888888"/>
            </map>
        </property>

        <!--第六种，Set注入-->
        <property name="games">
            <set>
                <value>LOL</value>
                <value>COC</value>
                <value>BOB</value>
            </set>
        </property>

        <!--第七种，null注入-->
        <property name="wife">
            <null/>
        </property>

        <!--第八种，properties注入-->
        <property name="info">
            <props>
                <prop key="学号">2016551206</prop>
                <prop key="性别">girl</prop>
                <prop key="emial">1486460308@qq.com</prop>
            </props>
        </property>
    </bean>
</beans>
```

4、测试类

```java
public class MyTest04 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
        
        /**
         * name='long'
         * address=Address{address='福建省龙岩市'}
         * books=[红楼梦, 西游记, 水浒传]
         * hobbys=[听歌, 敲代码, 看电影]
         * card={身份证=666666, 银行卡=888888}
         * games=[LOL, COC, BOB]
         * info={学号=2016551206, 性别=girl, emial=1486460308@qq.com}
         * wife='null'
         */
    }
}
```

#### 7.3  其它方式注入

我们可以使用c命名空间和p命名空间进行注入：

使用前要导入约束依赖：

```xml
xmlns:p="http://www.springframework.org/schema/p"
```

```xml
  xmlns:c="http://www.springframework.org/schema/c"
```


使用：      

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--p命名空间注入，可以直接注入属性的值：property-->
    <bean id="user" class="com.abraham.pojo.User" p:name="long" p:age="24"/>

    <!--c命名空间注入，可以通过构造器注入属性的值：construct-args-->
    <bean id="user2" class="com.abraham.pojo.User" c:name="long" c:age="24"/>

</beans>
```

#### 7.4  Bean的作用域

![image-20200908144247057](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908144247057.png)

单例模式（Spring默认的机制）：

![img](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/images/singleton.png)

```xml
<!-- the following is equivalent, though redundant (singleton scope is the default) -->
<bean id="accountService" class="com.something.DefaultAccountService" scope="singleton"/>
```

原型模式：每次从容器get的时候都会产生新的对象。

![prototype](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/images/prototype.png)

```xml
<bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/>
```

其余的request、session、application这些只能在web中使用到

----

### 8. Bean的自动装配

> ==工程5：spring-05-autowired1==

- 自动装配是Spring满足依赖的一种方式；

- Spring会在上下文中自动寻找，并给Bean装配属性；

  

> 在Spring中有三种装配方式
>
> 1、在xml中显示的配置
>
> 2、在Java中显示配置
>
> 3、隐式的自动装配Bean【重要】

#### 8.1 装配方式：ByName和ByType自动装配

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="cat" class="com.abraham.pojo.Cat"/>
    <bean id="dog666" class="com.abraham.pojo.Dog"/>
    <!--
        byName:会自动在容器上下文中查找和自己对象set方法后面的值对应的bean-id;
        byType:会自动在容器上下文中查找和自己对象属性类型相同的bean (必须保证装配全局唯一,可省略id参数);
        
    -->
    <bean id="people" class="com.abraham.pojo.People" autowire="byType">
        <property name="name" value="long"/>
<!--        <property name="dog" ref="dog"/>-->
<!--        <property name="cat" ref="cat"/>-->
    </bean>
</beans>
```

==**小结：**==

- byname需要保证所有的bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致；

  ![image-20200908113210094](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908113210094.png)

  ![image-20200908113229664](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908113229664.png)

  

- bytype需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性类型一致；

![image-20200908113329995](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908113329995.png)

![image-20200908113311277](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908113311277.png)



#### 8.2 使用注解实现自动装配

jdk1.5开始支持注解，spring2.5开始支持注解；

使用注解比在xml中配置自动装配更方便；

使用注解须知：

​		1、导入约束；==context约束==

​		2、配置注解的支持；==<context:annotation-config/>==

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```

![image-20200908114323344](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908114323344.png)



##### @Autowired

直接在属性上使用或者是在set方式上使用；也能在构造方法上使用；

```java
public class People {
    @Autowired  // 在属性上使用@Autowired注解
    private Cat cat;
//    @Autowired
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    @Autowired  // 在set方法上使用@Autowired注解
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

使用了@Autowired注解之后我们可以不用编写set方法了，前提是你这个自动在装配的属性在IOC容器中存在且符合ByName的名字要求；

@Autowired(required = false)   如果显示定义了@Autowired的required属性值为false。说明这个对象可以为null，否则不允许为空，该方法的使用

与注解@Nullable的使用相同；

```java
@Nullable    // 该注解标记的字段可以为null值
```

![image-20200908140559602](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908140559602.png)

**@Autowired标注的属性值可以与xml文件中的bean字段的id不相同，也可以识别并自动装配成功；**

![image-20200908141055762](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908141055762.png)

![image-20200908141004324](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908141004324.png)

**但是如果@Autowired自动装配的环境比较复杂（属性值与bean中的id都不相同时），自动装配无法通过一个注解【@Autowired】来完成的时候，我们可以使用@Qualifier(value="xxx")去配置@Autowired的使用，指定一个唯一的bean对象注入；**

![image-20200908141655773](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908141655773.png)

![image-20200908141608041](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908141608041.png)

##### @Resource注解

该注解用法类似@Autowired注解

```java
public class People {
    @Resource   // 该注解为java的原生注解，与@Autowired注解的功能相似
//    @Autowired  // 在属性上使用@Autowired注解
    private Cat cat;
    @Autowired
    @Qualifier(value = "dog2")
    private Dog dog;
    private String name;
}
```

@Autowired注解与@Resource注解的区别：

- 都是用来自动装配 ，都可以放在属性字段上；
- @Autowired 通过ByType的方式实现，而且必须要求这个对象存在；
- @Resource 默认通过ByName的方式实现，如果找不到名字，则通过ByType实现，如果两个都找不到的情况下就会报错；
- 执行的顺序不同：@Autowired通过ByType的方式实现；

----

### 9. 使用注解开发

> ==工程6：spring-06-anno==

在Spring4之后，如果要使用注解开发必须保证aop的包导入成功；

![image-20200908144755402](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908144755402.png)

使用注解之前需要导入context约束，增加注解的支持；

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/beans/spring-context.xsd">

    <context:annotation-config/>

</beans>
```



#### 9.1  Bean

参照第8点

#### 9.2  属性如何注入

```java
@Component
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
```

@Value注解可以给属性赋值，在属性上和set方法上使用均可；

#### 9.3  衍生的注解

@Component（pojo）的衍生注解，我们在web开发中会按照mvc三层架构分层：

- dao  	   	【@Repository】

- service       【@Service】
- controller  【@Controller】

以上这四个注解的功能是一样的，都是实现将某个类注册到Spring中，装配Bean；

#### 9.4  自动装配

参照第8点

#### 9.5  作用域

具体类同7.4节的内容

```
@Scope  设置作用域：singleton：为单例模式   prototype：为原型模式
```

![image-20200908153710893](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908153710893.png)

#### 9.6  小结

**XML与注解的对比：**

- xml更加万能，适用于任何场合，维护更加方便；
- 注解 如果不是自己的类就使用不了，维护相对复杂；

**XML与注解的最佳实践：**

- xml用来管理Bean；
- 注解只负责完成属性的注入；
- 我们在使用的过程中只需要注意：必须让注解生效，要开启注解的支持；

----

### 10. 使用java的方式配置Spring

> ==工程7：spring-07-appconfig==

**该章节要实现完全不使用spring的xml配置，全权交给 Java来做！！**

Javaconfig是Spring的一个子项目，在Spring4 之后变成了一个核心功能。

![image-20200908172921132](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20200908172921132.png)

实体类：

```java
@Component
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("long")	// 注入值
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

```

配置类：

```java
@Configuration  // 代表这是一个配置类，和之前学习的bean.xml是一样的
                // 这个注解也会被Spring容器托管，注册到容器中，因为它本来就是一个Component
@ComponentScan("com.abraham.pojo")
@Import(LongConfig2.class)	// 把另外一个配置类导进来可以一起用
public class LongConfig {

    // 注册一个Bean，相当于一个Bean标签，这个方法的名字就是相当于bean标签中的id属性，这个方法的返回值就相当于bean标签中的class属性
    @Bean
    public User user(){ // 方法名等于Bean的id
        return new User();  //返回要注入的bean对象
    }
}
```

测试类：

```java
public class MyTest07 {
    public static void main(String[] args) {
        // 如果完全使用了配置类方式去做，我们就只能通过AnnotationConfigApplicationContext上下文来获取容器，通过配置类的class对象加载
        ApplicationContext context = new AnnotationConfigApplicationContext(LongConfig.class);
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
    }
}
```

---

### 11. 代理模式

为什么要学习代理模式？     因为这就是Spring AOP的底层。   【Spring AOP】与【Spring MVC】是重点

代理模式的分类：

- 静态代理
- 动态代理





























