package com.xch.test;

import com.xch.proxy.UserServiceProxy;
import com.xch.service.UserService;
import com.xch.service.impl.UserServiceImpl;


/**
 * @author xiech
 * @create 2020-01-16 9:41
 */
public class Test01 {
    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        UserServiceProxy userServiceProxy=new UserServiceProxy(userService);
        userServiceProxy.add();
    }
}
