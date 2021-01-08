package com.example.demo_2020_1211.bean.component;

import com.example.demo_2020_1211.bean.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Bean 注解作用在方法上
 * @Bean 指示一个方法返回一个 Spring 容器管理的 Bean
 * @Bean 方法名与返回类名一致，首字母小写
 * @Bean 一般和 @Component 或者 @Configuration 一起使用
 * @Bean 注解默认作用域为单例 singleton 作用域，可通过 @Scope(“prototype”) 设置为原型作用域
 *
 * @Bean 注解常常与 @Scope、@Lazy，@DependsOn 和 @link Primary 注解一起使用：
 * @Profile 注解：为在不同环境下使用不同的配置提供了支持，如开发环境和生产环境的数据库配置是不同的
 * @Scope 注解：将 Bean 的作用域从单例改变为指定的作用域
 * @Lazy 注解：只有在默认单例作用域的情况下才有实际效果
 * @DependsOn 注解：表示在当前 Bean 创建之前需要先创建特定的其他 Bean
 */
@Configuration
public class BeanConfigration {

    @Bean({"myBean_1", "myBean_2"})
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    @Scope("singleton")
    public MyBean singleton_bean() {
        return new MyBean();
    }

    @Bean
    @Scope("prototype")
    public MyBean prototype_bean() {
        return new MyBean();
    }

    @Bean(initMethod="init", destroyMethod="destroy")
    public MyBean init_destroy() {
        MyBean myBean = new MyBean();
        myBean.setPort("8080");
        return myBean;
    }
}
