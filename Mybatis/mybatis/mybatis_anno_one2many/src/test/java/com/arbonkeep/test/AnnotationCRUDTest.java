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
import java.util.Date;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/19 - 17:00
 */
public class AnnotationCRUDTest {
    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao dao;

    @Before
    public void init() throws IOException {
        //读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //获取sqlSession对象
        sqlSession = factory.openSession();
        //获取代理对象
        dao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println("-----------每个用户的信息------------");//一对多
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    /**
     * 测试查询一个
     */
    @Test
    public void testFindById() {
        User user1 = dao.findById(58);
        System.out.println(user1);

        User user2 = dao.findById(58);
        System.out.println(user2);

        System.out.println(user1 == user2);
        //一级缓存是相同的


    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testSelectByName(){
        List<User> users = dao.SelectByName("%王%");
//        dao.SelectByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int total = dao.findTotal();
        System.out.println(total);
    }
}
