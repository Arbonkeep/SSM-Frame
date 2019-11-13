package com.arbonkeep.dao.impl;

import com.arbonkeep.dao.IUserDao;
import com.arbonkeep.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/13 - 16:44
 */
public class UserDaoImpl implements IUserDao {
    //声明一个工厂用于获取factory
    private SqlSessionFactory factory;

    //构造器，通过构造器将指定factory闯入
    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        //1.通过factory获取session
        SqlSession session = factory.openSession();
        //2.使用sseion执行查询所有的方法
        List<User> users = session.selectList("com.arbonkeep.dao.IUserDao.findAll");
        //3.关闭资源返回结果
        session.close();
        return users;
    }
}
