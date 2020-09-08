### 注解说明
- @Autowired：自动装配，通过类型、名字识别；
- @Qualifier：如果@Autowired不能唯一自动装配上属性，则通过该注解的value字段赋值为false来解决即@Qulifier(value = false)；
- @Nullable：如果某字段标记了该注解，说明这个字段可以为null；
- @Resource：自动装配，通过类型、名字识别，类似于@Autowired注解，是java原生注解；
- @Value：给属性赋值，可用在属性上也可以用在Set方法上，效果相同；

- @Component：组件，放在类上，说明这个类被Spring管理了，等价于Bean；

