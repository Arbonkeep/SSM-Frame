package com.arbonkeep.mybatis.sqlsession;

import com.arbonkeep.mybatis.cfg.Configuration;
import com.arbonkeep.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.arbonkeep.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author arbonkeep
 * @date 2019/11/13 - 20:16
 * 用于创建一个SqlSessionFactory
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来创建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }

}
