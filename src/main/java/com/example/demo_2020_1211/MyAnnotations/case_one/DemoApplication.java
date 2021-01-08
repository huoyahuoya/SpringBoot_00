package com.example.demo_2020_1211.MyAnnotations.case_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        try {
            ClassMethodAnnotationTest();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void ClassMethodAnnotationTest() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Class testClass = test.class;
        Method[] method = testClass.getMethods();
        for (Method method2 : method) {
            if(method2.isAnnotationPresent(ClassMethodAnnotation.class)){
                ClassMethodAnnotation annotation = method2.getAnnotation(ClassMethodAnnotation.class);
                Class annClass = annotation.c();
                String annMethod = annotation.method();
                Method[] anmethod = annClass.getMethods();
                for (Method method3 : anmethod) {
                    if(method3.getName().equals(annMethod)){
                        System.out.println("带注解的方法为："+method2.getName());
                        method3.invoke(annClass.newInstance(), null);
                    }
                }
            }
        }
    }

}
