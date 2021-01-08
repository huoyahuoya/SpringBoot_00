#@Configration 注解详解

##1，使用说明

@Configration 注解作用在类、接口（包含注解）上

@Configuration 用于定义配置类，可替换 xml 配置文件

@Configration 注解类中可以声明一个或多个 @Bean 方法

@Configration 注解作用的类不能是 final 类型

嵌套的 @Configration 类必须是 static 的

##2，声明一个 @Bean 方法
###（1）假设我们定义一个如下的 Bean：
```
package com.example.demo.bean;

public class MyBean {
private String port;

    public void init() {
        System.out.println("MyBean开始初始化...");
    }
 
    public void destroy() {
        System.out.println("MyBean销毁...");
    }
 
    public String get() {
        return "端口号： " + getPort();
    }
 
    public String getPort() {
        return port;
    }
 
    public void setPort(String port) {
        this.port = port;
    }
}
```

###（2）然后在 Configuration 中进行声明：
```
@Configuration
public class MyConfigration {
    @Bean(initMethod="init", destroyMethod="destroy")
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setPort("8080");
        return myBean;
    }
}
```
###（3）最后进行测试，我们获取这个 Bean 并输出其内容：
```
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context
                = SpringApplication.run(DemoApplication.class, args);
        MyBean myBean = (MyBean) context.getBean("myBean");
        System.out.println(myBean.get());
    }
}
```
![Image text](https://www.hangge.com/blog_uploads/201907/2019071219535017278.png)

##3，声明多个 @Bean 方法
###（1）@Configration 注解类中可以声明多个 @Bean 方法，并且 bean 与 bean 之间是可以有依赖关系的。如果一个 bean 的定义依赖其他 bean，则直接调用对应的 JavaConfig 类中依赖 bean 的创建方法就可以了。
###（2）下面是一个简单的样例，一共声明了 country 和 userInfo 两个 Bean。
注意：@Configuration 注解的 bean 都已经变成了增强的类。因此上面的 country 这个 Bean 和下面直接调用 country() 方法返回的是同一个实例
```
@Configuration
public class MyBeanConfig {

    @Bean
    public Country country(){
        return new Country();
    }
  
    @Bean
    public UserInfo userInfo(){
        return new UserInfo(country());
    }
}
```