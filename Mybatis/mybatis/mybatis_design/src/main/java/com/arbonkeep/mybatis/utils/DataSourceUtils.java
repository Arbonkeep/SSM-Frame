package com.arbonkeep.mybatis.utils;

import com.arbonkeep.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author arbonkeep
 * @date 2019/11/14 - 14:22
 */
public class DataSourceUtils {
    /**
     * 用于获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }
}
