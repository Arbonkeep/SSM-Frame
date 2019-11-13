package com.arbonkeep.mybatis.sqlsession;

/**
 * @author arbonkeep
 * @date 2019/11/13 - 20:21
 */
public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
