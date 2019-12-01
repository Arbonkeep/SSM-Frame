package com.arbonkeep.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author arbonkeep
 * @date 2019/11/30 - 14:16
 *
 * 连接的工具类。用于从数据源中获取一个链接，并且实现和线程的绑定
 */
@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal tl = new ThreadLocal<Connection>();

    //声明一个数据源用于获取连接，使用spring的注入数据
    @Autowired
    private DataSource dataSource;

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {
        try {
            //1.获取当前线程上的连接
            Connection conn = (Connection) tl.get();
            //2.判断当前线程上是否有连接
            if (conn == null) {
                //3.从数据源中获取一个连接，并和线程绑定即存入threadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 将线程和连接解绑
     */
    public void removeConnection() {
        tl.remove();
    }
}
