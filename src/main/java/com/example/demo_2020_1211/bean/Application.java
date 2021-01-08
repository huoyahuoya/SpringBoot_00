package com.example.demo_2020_1211.bean;

import com.example.demo_2020_1211.bean.bean.MyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        MyBean singleton_bean_1 = (MyBean) context.getBean("singleton_bean");
        System.out.println(System.identityHashCode(singleton_bean_1));
        MyBean singleton_bean_2 = (MyBean) context.getBean("singleton_bean");
        System.out.println(System.identityHashCode(singleton_bean_2));

        MyBean prototype_bean_1 = (MyBean) context.getBean("prototype_bean");
        System.out.println(System.identityHashCode(prototype_bean_1));
        MyBean prototype_bean_2 = (MyBean) context.getBean("prototype_bean");
        System.out.println(System.identityHashCode(prototype_bean_2));

        MyBean init_destroy = (MyBean) context.getBean("init_destroy");

//        context.close();
    }
}
