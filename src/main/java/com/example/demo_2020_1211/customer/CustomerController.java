package com.example.demo_2020_1211.customer;

import com.example.demo_2020_1211.readinglist.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class CustomerController {

    @RequestMapping("/CustomerController") //http://localhost:8080/CustomerController
    public String getByUserName(String userName) {
        testSave();
        return "保存成功";
    }


    public void testSave() {
//        //1.加载配置文件创建工厂（实体管理器工厂）对象
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
//        //2.通过实体管理器工厂获取实体管理器
//        EntityManager em = factory.createEntityManager();
//        //3.获取事务对象，开启事务
//        EntityTransaction tx = em.getTransaction(); //获取事务对象
//        tx.begin();
//        //4.完成增删改查操作：保存一个客户到数据库中
//        Customer customer = new Customer();
//        customer.setCustId((long)1);
//        customer.setCustName("传智播客3");
//        //保存，
//        em.persist(customer); //保存操作
//        //5.提交事务
//        tx.commit();
//        //6.释放资源
//        em.close();
//        factory.close();
        String persistenceUnitName = "myJpa";
        Map<String, Object> properites = new HashMap<>();
        properites.put("hibernate.show_sql","false");
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(persistenceUnitName,properites);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Book book = new Book();
        book.setId(1L);
        book.setAuthor("qweasd");
        book.setIsbn("qweasd");
        book.setDescription("qweasd");
        book.setTitle("qweasd");
        book.setReader("qweasd");
        entityManager.persist(book);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();



    }
}
