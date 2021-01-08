package com.example.demo_2020_1211.MyAnnotations.case_two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        try {
            FruitInfoUtil.getFruitInfo(Apple.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
