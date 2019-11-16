package com.arbonkeep.dao.impl;

import com.arbonkeep.dao.IUserDao;
import com.arbonkeep.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/16 - 13:23
 */
public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    //通过构造方法将factory传入
    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        //1.根据factory获取SqlSessio对象
        SqlSession sqlSession = factory.openSession();
        //2.调用sqlSession方法实现查询列表
        List<User> users = sqlSession.selectList("com.arbonkeep.dao.IUserDao.findAll");//这里参数是获取配置信息的key
        //3.释放资源返回users
        return users;
    }

    @Override
    public void save(User user) {
        //1.根据factory获取SqlSessio对象
        SqlSession sqlSession = factory.openSession();
        //2.调用保存方法,需要将user传入
        sqlSession.insert("com.arbonkeep.dao.IUserDao.save",user);
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();

    }

    @Override
    public void update(User user) {
        //1.根据factory获取sqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法更新
        session.update("com.arbonkeep.dao.IUserDao.update",user);
        //3.提交事务
        session.commit();
        //4.关闭资源
        session.close();
    }

    @Override
    public void delete(Integer id) {
        SqlSession session = factory.openSession();

        //session.delete("com.arbonkeep.dao.IUserDao.delete",id);
        //删除操作也可以调用update方法
        session.update("com.arbonkeep.dao.IUserDao.delete",id);

        session.commit();

        session.close();

    }

    @Override
    public User selectById(Integer id) {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("com.arbonkeep.dao.IUserDao.selectById", id);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> selectByName(String name) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.arbonkeep.dao.IUserDao.selectByName", name);
        session.commit();
        session.close();
        return users;
    }

    @Override
    public int findTotal() {
        SqlSession session = factory.openSession();
        int i = session.selectOne("com.arbonkeep.dao.IUserDao.findTotal");

        return i;
    }
}
