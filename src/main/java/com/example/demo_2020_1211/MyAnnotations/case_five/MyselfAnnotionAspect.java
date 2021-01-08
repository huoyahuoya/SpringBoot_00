package com.example.demo_2020_1211.MyAnnotations.case_five;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyselfAnnotionAspect {
    //通过切点表达式定义切点
    @Pointcut("execution(* com.enjoyican.demo.selfannotion.service.impl..*(..))")
    public void myPointCut(){};
    @Pointcut("@annotation(MyselfAnnotion)")
    public void myAnnoCut(){};

    //定义方法增强类型（本例子采用环绕增强）
    @Around("myAnnoCut()&&myPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("AOP切面在执行service方法之前增强");
        point.proceed();
        System.out.println("AOP切面在执行service方法之后增强");
        return null;
    }
}
