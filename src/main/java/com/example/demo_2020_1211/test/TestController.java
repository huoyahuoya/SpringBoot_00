package com.example.demo_2020_1211.test;

import com.example.demo_2020_1211.util.JDBCUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("测试开始");
        test_connect();
        return "测试开始???";
    }

    private void test_connect() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from test_00";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                System.out.println("springboot_00 log: id = " + id + " name = " + name );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, stmt, rs);
        }
    }
}
//http://localhost:8080/test/test