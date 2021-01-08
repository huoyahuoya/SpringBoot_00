package com.example.demo_2020_1211.MyAnnotations.case_four;

import com.example.demo_2020_1211.MyAnnotations.case_three.MyselfAnnotion;
import org.springframework.stereotype.Service;

@Service
public class MyAnnotionTestServiceImpl implements MyAnnotionTestService {
    @Override
    @MyselfAnnotion
    public void testAopAnnotion() {
        System.out.println("我来自service层，我用来测试自定义注解");
    }
}
