package com.arbonkeep.mybatis.sqlsession.defaults;

import com.arbonkeep.mybatis.cfg.Configuration;
import com.arbonkeep.mybatis.sqlsession.SqlSession;
import com.arbonkeep.mybatis.sqlsession.SqlSessionFactory;

/**
 * @author arbonkeep
 * @date 2019/11/14 - 13:16
 * SqlSessionFactory的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
