[comment]: <> (https://www.hangge.com/blog/cache/detail_2506.html)

#一、基本用法
1，基本介绍
Spring Boot 推荐使用 java 配置完全代替 XML 配置，java 配置是通过 @Configration 和 @Bean 注解实现的。二者作用如下：

@Configration 注解：声明当前类是一个配置类，相当于 Spring 中的一个 XML 文件

@Bean 注解：作用在方法上，声明当前方法的返回值是一个 Bean

2，简单样例
（1）首先创建一个自定义的配置类 MyConfigration：

使用 @Configration 注解将该类声明为一个配置类。

在 hello() 方法上添加 @Bean 注解则会往 Spring 容器中添加一个名为 hello 的 Bean，该 Bean 即为方法的返回值。

```
package com.example.demo.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigration {
    @Bean
    public String hello() {
        return "welcome to hangge.com";
    }
}
```
（2）下面我们在一个 Controller 中获取并使用这个 Bean，代码如下：
```
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    String hello;
 
    @GetMapping("/test")
    public String test() {
        return hello;
    }
}
```
（3）访问这个 Controller，运行结果如下：

![Image text](https://www.hangge.com/blog_uploads/201907/2019071218422865712.png)

#二、@Bean 注解详解
##1，使用说明
@Bean 注解作用在方法上

@Bean 指示一个方法返回一个 Spring 容器管理的 Bean

@Bean 方法名与返回类名一致，首字母小写

@Bean 一般和 @Component 或者 @Configuration 一起使用

@Bean 注解默认作用域为单例 singleton 作用域，可通过 @Scope(“prototype”) 设置为原型作用域


##2，Bean 名称
###（1）默认情况下 Bean 名称就是方法名，比如下面 Bean 名称便是 myBean：
```
@Bean
public MyBean myBean() {
    return new MyBean();
}
```

###（2）@Bean 注解支持设置别名。比如下面除了主名称 myBean 外，还有个别名 myBean1（两个都可以使用）
```
@Bean("myBean1")
public MyBean myBean() {
    return new MyBean();
}
```

###（3）@Bean 注解可以接受一个 String 数组设置多个别名。比如下面除了主名称 myBean 外，还有别名 myBean1、myBean2（三个都可以使用）
```
@Bean({"myBean1", "myBean2"})
public MyBean myBean() {
return new MyBean();
}
```

##3，@Bean 与其他注解一起使用
###（1）@Bean 注解常常与 @Scope、@Lazy，@DependsOn 和 @link Primary 注解一起使用：

@Profile 注解：为在不同环境下使用不同的配置提供了支持，如开发环境和生产环境的数据库配置是不同的

@Scope 注解：将 Bean 的作用域从单例改变为指定的作用域

@Lazy 注解：只有在默认单例作用域的情况下才有实际效果

@DependsOn 注解：表示在当前 Bean 创建之前需要先创建特定的其他 Bean

###（2）比如下面样例，Bean 的作用域默认是单例的，我们配合 @Scope 注解将其改成 prototype 原型模式（每次获取 Bean 的时候会有一个新的实例）
```
@Bean()
@Scope("prototype")
public MyBean myBean() {
return new MyBean();
}
```
##4，Bean 初始化和销毁时调用相应的方法
###（1）实际开发中，经常会遇到在 Bean 使用之前或使用之后做些必要的操作，Spring 对 Bean 的生命周期的操作提供了支持：我们可以通过 @Bean 注解的 initMethod 和 destrodMethod 进行指定 Bean 在初始化和销毁时需要调用相应的方法。

###（2）下面是一个简单的样例：
```
public class MyBean {
public void init() {
System.out.println("MyBean开始初始化...");
}

    public void destroy() {
        System.out.println("MyBean销毁...");
    }
 
    public String get() {
        return "MyBean使用...";
    }
}
```
```
@Bean(initMethod="init", destroyMethod="destroy")
public MyBean myBean() {
    return new MyBean();
}
```

#三、Spring Bean加载顺序问题
结论：
@Configuration、@Service、@Component 都会将修饰的类交给 spring 来管理，但就注解这个层面来说，貌似是没有加载顺序的。

默认为 包名+文件名 来判断加载顺序。

如果需要指定加载顺序，可以使用 @DependsOn 注解。

@PostConstruct 是jdk中的一个注解， 被 @PostConstruct 修饰的方法会在服务器加载 Servlet 的时候运行，并且只会被服务器调用一次。

例子：
```
@Configuration
@DependsOn({"initConfig", "aaa"})
public class Bb {
}
```
@DependsOn 可以指定多个 bean ，用 String[] 表示，有顺序。

@DependsOn({"initConfig", "aaa"}) 表示在执行 Bb.java 之前，会首先执行 InitConfig.java，然后再执行 Aaa.java。

```
参考路径：
https://blog.csdn.net/jourey_for_you/article/details/109602558
https://blog.csdn.net/qq_33220089/article/details/104969239
```