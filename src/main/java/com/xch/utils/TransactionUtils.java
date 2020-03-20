package com.xch.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @author xiech
 * @create 2020-01-16 14:17
 */
@Component
@Scope("prototype")
public class TransactionUtils {
    private TransactionStatus transactionStatus;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    public TransactionStatus begin(){
        System.out.println("开启事务");
         transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return transactionStatus;
    }

    public void commit(){
        System.out.println("提交事务");
        dataSourceTransactionManager.commit(transactionStatus);
    }

    public void rollback(){
        dataSourceTransactionManager.rollback(transactionStatus);
    }

}
