package com.example.demo_2020_1211.MyAnnotations.case_three;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class MyAnnotionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod) handler;
            //1获取方法上的注解
            MyselfAnnotion methodAnnotation = method.getMethodAnnotation(MyselfAnnotion.class);
            //2获取类上的注解
            //MyselfAnnotion annotation = method.getBeanType().getAnnotation(MyselfAnnotion.class);
            //3获取类中属性的注解
            /*Field[] declaredFields = method.getBeanType().getDeclaredFields();
            for (Field field:declaredFields){
                field.setAccessible(true);
                MyselfAnnotion annotation = field.getAnnotation(MyselfAnnotion.class);
            }*/
            if (null == methodAnnotation){
                return true;
            }
            if (MyAnnotionEnum.GUANYU.getName().equals(methodAnnotation.name())){
                System.out.println("拦截器检测到是五虎上将" + methodAnnotation.name());
            }else {
                System.out.println("拦截器检测到不是关羽，是"+ methodAnnotation.name() +"不能通关");
                return false;
            }
            if (MyAnnotionEnum.GUANYU.getAge().equals(methodAnnotation.age())){
                System.out.println("拦截器检测到这是18岁的关羽，威猛，过关");
                return true;
            }else {
                System.out.println("拦截器检测到这个关羽老了，不能通关");
                return false;
            }
        }
        return false;
    }
}
