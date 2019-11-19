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
    private SqlSession sqlSession;
    private IUserDao dao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlSession工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取sqlSession对象
        sqlSession = factory.openSession();
        //4.获取代理对象dao
        dao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        //6.提交事务
        sqlSession.commit();
        //7.关闭资源
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll() {
        //1.使用代理对象调用findAll方法
        List<User> users = dao.findAll();

        //2.遍历
//        for (User user : users) {
//            System.out.println("----------每一个用户的详细信息---------");
//            System.out.println(user);
//            System.out.println(user.getAccounts());//获取用户的账户信息
//        }

    }
}
