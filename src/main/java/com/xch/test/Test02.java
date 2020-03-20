package com.xch.test;

import com.xch.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiech
 * @create 2020-01-16 11:47
 */
public class Test02 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService= (UserService) applicationContext.getBean("userServiceImpl");
        userService.add();
    }
}
