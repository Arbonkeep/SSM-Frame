package com.arbonkeep.mybatis.sqlsession.defaults;

import com.arbonkeep.dao.IUserDao;
import com.arbonkeep.mybatis.cfg.Configuration;
import com.arbonkeep.mybatis.sqlsession.SqlSession;
import com.arbonkeep.mybatis.sqlsession.proxy.MapperProxy;
import com.arbonkeep.mybatis.utils.DataSourceUtils;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author arbonkeep
 * @date 2019/11/14 - 13:22
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtils.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        T t = (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), connection));//使用自己的方式创建代理对象
        return t;
    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
