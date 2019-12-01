package com.arbonkeep.utils;

/**
 * @author arbonkeep
 * @date 2019/11/26 - 14:36
 * 与事务相关的工具类：包含开启事务，提交事务，回滚事务，释放连接
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    //提供set方法
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务的方法
     */
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
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();//这里关闭资源是将资源放回连接池
            connectionUtils.removeConnection();//解绑连接与线程
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
