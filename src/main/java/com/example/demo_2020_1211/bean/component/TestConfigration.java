package com.example.demo_2020_1211.bean.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Configration 注解：声明当前类是一个配置类，相当于 Spring 中的一个 XML 文件
 * @Bean 注解：作用在方法上，声明当前方法的返回值是一个 Bean
 */



//使用 @Configration 注解将该类声明为一个配置类。
@Configuration
public class TestConfigration {

    //在 hello() 方法上添加 @Bean 注解,
    // 则会往 Spring 容器中添加一个名为 hello 的 Bean,
    // 该 Bean 即为方法的返回值。
    @Bean
    public String hello() {
        return "hello word";
    }
    @Bean
    public String hello_1() {
        return "hello_1 word";
    }

    @Bean
    public  int flag(){

        return 1;
    }

    @Bean
    public String hello_2(int flag){
        switch(flag){
            case 1:
                return "case 1";
            case 2:
                return "case 2";
            case 3:
                return "case 3";
            default:
                return "default";
        }

    }
}
