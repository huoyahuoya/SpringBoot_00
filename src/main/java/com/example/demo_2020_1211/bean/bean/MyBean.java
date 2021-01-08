package com.example.demo_2020_1211.bean.bean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MyBean {

    private String port;

    public void init() {
        System.out.println("MyBean开始初始化...");
    }

    public void destroy() {
        System.out.println("MyBean销毁...");
    }

    public String get() {
//        return "MyBean使用...";
        return "端口号： " + getPort();
    }
}
