package com.xch.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xiech
 * @create 2020-01-16 10:58
 */
@Component
@Aspect
public class AopLog {
 /*   @Before("execution(* com.xch.service.UserService.add(..))")
    public void before(){
        System.out.println("前置通知！");

    }

    @After("execution(* com.xch.service.UserService.add(..))")
    public void after(){
        System.out.println("后置通知！");
    }

    @AfterReturning("execution(* com.xch.service.UserService.add(..))")
    public void afterReturning(){
        System.out.println("运行通知！");
    }

    @AfterThrowing("execution(* com.xch.service.UserService.add(..))")
    public void afterThrowing(){
        System.out.println("异常通知！");
    }

    @Around("execution(* com.xch.service.UserService.add(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕通知之前");
        point.proceed();
        System.out.println("环绕通知之后");
    }*/
}
