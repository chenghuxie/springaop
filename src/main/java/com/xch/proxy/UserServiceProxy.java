package com.xch.proxy;

import com.xch.service.UserService;

/**
 * @author xiech
 * @create 2020-01-16 11:44
 */
public class UserServiceProxy {
    private UserService userService;

    public UserServiceProxy(UserService userService){
        this.userService=userService;
    }

    public void add(){
        System.out.println("开始");
        userService.add();
        System.out.println("结束");
    }
}
