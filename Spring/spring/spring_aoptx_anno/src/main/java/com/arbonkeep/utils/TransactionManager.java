package com.arbonkeep.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arbonkeep
 * @date 2019/11/30 - 15:38
 * 与事务相关的工具类：包含开启事务，提交事务，回滚事务，释放连接
 */
@Component("txManager")
@Aspect//表示当前类是一个切面类
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    //声明一个通用的切入点方法
    @Pointcut("execution(* com.arbonkeep.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 开启事务的方法
     */
    //@Before("pt1()")
    public void openTransaction() {
        try {
            //开启事务
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    //@AfterReturning("pt1()")
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    //@AfterThrowing("pt1()")
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    //@After("pt1()")
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();//这里关闭资源是将资源放回连接池
            connectionUtils.removeConnection();//解绑连接与线程
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Around("pt1()")//使用环绕通知完成事务的控制
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            //1.获取执行参数
            Object[] args = pjp.getArgs();
            //2.开启事务
            this.openTransaction();
            //3.执行方法
            result = pjp.proceed(args);
            //4.提交事务
            this.commit();
            //5.返回结果
            return result;

        } catch (Throwable t) {
            //6.回滚事务
            this.rollback();
            throw new RuntimeException(t);

        } finally {
            //7.释放资源
            this.release();

        }
    }
}
