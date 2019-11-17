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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/14 - 16:24
 */
public class MybatisTest {
    private InputStream is;
    private SqlSession session;
    private IUserDao dao;

    @Before//用于在测试方法之前执行
    public void init() throws Exception{
        //1.读取配置文件
         is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取session
         session = factory.openSession();
        //4.获取代理对象
         dao = session.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws IOException {
        //需要提交事务
        session.commit();
        //6.关闭资源
        session.close();
        is.close();
    }

    /**
     * 测试查询所有
     * @throws IOException
     */
    @Test
    public void testFindAll() throws IOException {


        //6.使用代理对象执行方法
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * 查询一个
     */
    @Test
    public void testselectById() {
        //使用代理对象查询
        User user = dao.selectById(49);
        System.out.println(user);
    }


}
