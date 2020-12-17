package com.example.demo_2020_1211.customer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 客户的实体类
 *      配置映射关系
 *
 *
 *   1.实体类和表的映射关系
 *      @Entity:声明实体类
 *      @Table : 配置实体类和表的映射关系
 *          name : 配置数据库表的名称
 *   2.实体类中属性和表中字段的映射关系
 *
 *
 */
@Entity
@Setter
@Getter
@ToString
@Table(name = "cst_customer")
public class Customer implements Serializable {

    /**
     * @Id：声明主键的配置
     * @GeneratedValue:配置主键的生成策略
     *      strategy
     *          GenerationType.IDENTITY ：自增，mysql
     *                 * 底层数据库必须支持自动增长（底层数据库支持的自动增长方式，对id自增）
     *          GenerationType.SEQUENCE : 序列，oracle
     *                  * 底层数据库必须支持序列
     *          GenerationType.TABLE : jpa提供的一种机制，通过一张数据库表的形式帮助我们完成主键自增
     *          GenerationType.AUTO ： 由程序自动的帮助我们选择主键生成策略
     * @Column:配置属性和字段的映射关系
     *      name：数据库表中字段的名称
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_id")
    private Long custId; //客户的主键

    @Column(name = "cust_name")
    private String custName;//客户名称

//    @Column(name="cust_source")//指定和表中cust_source字段的映射关系
//    private String custSource;
//
//    @Column(name="cust_industry")//指定和表中cust_industry字段的映射关系
//    private String custIndustry;
//
//    @Column(name="cust_level")//指定和表中cust_level字段的映射关系
//    private String custLevel;
//
//    @Column(name="cust_address")//指定和表中cust_address字段的映射关系
//    private String custAddress;
//
//    @Column(name="cust_phone")//指定和表中cust_phone字段的映射关系
//    private String custPhone;
}
