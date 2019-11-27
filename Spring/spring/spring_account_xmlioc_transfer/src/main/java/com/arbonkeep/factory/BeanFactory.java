package com.arbonkeep.factory;

import com.arbonkeep.service.AccountService;
import com.arbonkeep.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author arbonkeep
 * @date 2019/11/27 - 14:11
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {
    private AccountService accountService;//声明被代理对象

    private TransactionManager txManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 通过动态代理获取AccountService对象
     * @return
     */
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     *
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try {
                            //开启事务
                            txManager.openTransaction();
                            //执行方法
                            result = method.invoke(accountService,args );
                            //提交事务
                            txManager.commit();
                        }catch (Exception e) {
                            //回滚事务
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //释放资源
                            txManager.release();
                        }
                        return result;
                    }
                });
    }
}
