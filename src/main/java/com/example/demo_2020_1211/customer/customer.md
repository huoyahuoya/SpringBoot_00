#Customer

##建表
    CREATE TABLE cst_customer (
    cust_id number(10) NOT NULL,
    cust_name varchar(32) NOT NULL,
    cust_source varchar(32) DEFAULT NULL,
    cust_industry varchar(32) DEFAULT NULL,
    cust_level varchar(32) DEFAULT NULL,
    cust_address varchar(128) DEFAULT NULL,
    cust_phone varchar(64) DEFAULT NULL);

##创建主键
    alter table CST_CUSTOMER add constraint cust_id primary key (cust_id);

##自增序列
    create sequence seq_on_cst_customer
    increment by 1
    start with 1
    nomaxvalue
    nocycle
    nocache;

##自增测试
    insert into cst_customer(cust_id,cust_name) values(seq_on_cst_customer.nextval, '测试公司');

##查询
    select * from cst_customer;