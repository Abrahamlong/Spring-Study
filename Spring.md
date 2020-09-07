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



### 4. IOC控制反转

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

 XML的配置文件：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

</beans>
```



### 5. IOC创建对象的方式

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



### 6. Spring配置

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



### 7. 依赖注入（DI)

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
public class MyTest {
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

![image-20200907213340735](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20200907213340735.png)

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



### 8. Bean的自动装配

- 自动装配是Spring满足依赖的一种方式；

- Spring会在上下文中自动寻找，并给Bean装配属性；

  

> 在Spring中有三种装配方式
>
> 1、在xml中显示的配置
>
> 2、在Java中显示配置
>
> 3、隐式的自动装配Bean【重要】

#### 8.1  测试































