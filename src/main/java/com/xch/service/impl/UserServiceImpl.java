package com.xch.service.impl;

import com.xch.annontion.AddAnnontion;
import com.xch.annontion.ExtTransactional;
import com.xch.dao.UserDao;
import com.xch.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;


/**
 * @author xiech
 * @create 2020-01-16 9:40
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @ExtTransactional
    @Override
    public void add() {
        userDao.add("test01",20);
        System.out.println("");
        userDao.add("test02",21);
    }

    public void del(){
        System.out.println("删除");
    }

 /*   public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.xch.service.impl.UserServiceImpl");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            AddAnnontion addAnnontion = method.getDeclaredAnnotation(AddAnnontion.class);
            if(addAnnontion==null){
                System.out.println("没有注解");
                continue;
            }
            System.out.println(addAnnontion.age());
            System.out.println(addAnnontion.name());
            System.out.println(addAnnontion.arrays());
        }
    }*/
}
