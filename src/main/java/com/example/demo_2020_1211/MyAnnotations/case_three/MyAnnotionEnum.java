package com.example.demo_2020_1211.MyAnnotations.case_three;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MyAnnotionEnum {
    LIUBEI("liubei",48),
    ZHANGFEI("zhangfei",24),
    GUANYU("guanyu",18);

    private String name;
    private Integer age;
}
