package com.arbonkeep.test;

import com.arbonkeep.dao.IUserDao;
import com.arbonkeep.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/18 - 12:28
 * 测试一对多的关系
 */
public class UserTest {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao dao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlSession工厂对象
        factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取sqlSession对象
        sqlSession = factory.openSession();
        //4.获取代理对象dao
        dao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        //6.提交事务
        //sqlSession.commit();
        //7.关闭资源
        sqlSession.close();
        is.close();
    }

    /**
     * 演示一级缓存
     */
    @Test
    public void testFirstLevelCache() {
        User user1 = dao.selectById(41);
        System.out.println(user1);
        //关闭sqlSession
//        sqlSession.close();

        //重新获取sqlSession对象
//        SqlSession sqlSession = factory.openSession();

        sqlSession.clearCache();//此方法也可以清空缓存

        //重新获取代理对象
        dao = sqlSession.getMapper(IUserDao.class);

        User user2 = this.dao.selectById(41);
        System.out.println(user2);
        System.out.println(user1 == user2);

    }

    /**
     * 测试缓存的同步
     */
    @Test
    public void testClearCache() {
        //1.根据id查询用户
        User user1 = dao.selectById(41);
        System.out.println(user1);
        //2.更新用户信息
        user1.setUsername("小时");
        user1.setAddress("南昌西");
        dao.updateUser(user1);
        //3.再次查询用户id为41的用户
        User user2 = dao.selectById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);


    }

}
