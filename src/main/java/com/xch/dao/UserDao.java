package com.xch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author xiech
 * @create 2020-01-16 14:08
 */
@Repository
public class UserDao {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void add(String name,Integer age){
        String sql = "INSERT INTO user(NAME, age) VALUES(?,?);";
        int updateResult = jdbcTemplate.update(sql, name, age);
        System.out.println("updateResult:" + updateResult);
    }
}
