package com.xch.aop;

import java.lang.reflect.Method;

import com.xch.annontion.ExtTransactional;
import com.xch.utils.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

/**
 * @author xiech
 * @create 2020-01-16 14:25
 */
@Component
@Aspect
public class AopTransaction {
/*
    @Autowired
    private TransactionUtils transactionUtils;

   */
/* @AfterThrowing("execution(* com.xch.service.*.*.*(..))")
    public void afterThrowing(){
        System.out.println("事务回滚");
        transactionUtils.rollback();
    }*//*


    @Around("execution(* com.xch.service.*.*.*(..))")
    public void around(ProceedingJoinPoint point) throws Throwable,Exception {
        //1 获取代理对象方法
         //获取方法名称
        String methodName=point.getSignature().getName();
         //获取目标对象
        Class<?> aClass = point.getSignature().getClass();
         //获取目标对象类型
        Class[] parameterTypes = ((MethodSignature)point.getSignature()).getParameterTypes();
        //获取目标对象方法
        Method method = aClass.getMethod(methodName, parameterTypes);
        //2 获取该方法上是否加上注解
        ExtTransactional declaredAnnotation = method.getAnnotation(ExtTransactional.class);
        TransactionStatus transactionStatus=null;
        if(declaredAnnotation!=null){
            //3 如果存在事务注解 开启事务
            transactionStatus=transactionUtils.begin();
        }
        //4 调用目标代理对象
        point.proceed();

        //5 判断是否需要提交事务

            transactionUtils.commit();

    }
*/


	@Autowired
	private TransactionUtils transactionUtils;

	// 使用异常通知进行 回滚事务
	@AfterThrowing("execution(* com.xch.service.*.*.*(..))")
	public void afterThrowing() {
		// 获取当前事务进行回滚
		// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		transactionUtils.rollback();
	}

	// 环绕通知 在方法之前和之后处理事情
	@Around("execution(* com.xch.service.*.*.*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {

		// 1.获取该方法上是否加上注解
		ExtTransactional extTransaction = getMethodExtTransaction(pjp);
		TransactionStatus transactionStatus = begin(extTransaction);
		// 2.调用目标代理对象方法
		pjp.proceed();
		// 3.判断该方法上是否就上注解
		commit();
	}

	private TransactionStatus begin(ExtTransactional extTransaction) {
		if (extTransaction == null) {
			return null;
		}
		// 2.如果存在事务注解,开启事务
		return transactionUtils.begin();
	}

	private void commit() {
		transactionUtils.commit();
	}

	// 获取方法上是否存在事务注解
	private ExtTransactional getMethodExtTransaction(ProceedingJoinPoint pjp)
			throws NoSuchMethodException, SecurityException {
		String methodName = pjp.getSignature().getName();
		// 获取目标对象
		Class<?> classTarget = pjp.getTarget().getClass();
		// 获取目标对象类型
		Class<?>[] par = ((MethodSignature) pjp.getSignature()).getParameterTypes();
		// 获取目标对象方法
		Method objMethod = classTarget.getMethod(methodName, par);
		ExtTransactional extTransaction = objMethod.getAnnotation(ExtTransactional.class);
		return extTransaction;
	}
}
