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

import javax.xml.stream.FactoryConfigurationError;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author arbonkeep
 * @date 2019/11/19 - 19:50
 */
public class SecondLevelCacheTest {
    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao dao;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        //读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取工厂对象
        factory = new SqlSessionFactoryBuilder().build(is);
        //获取sqlSession对象
        sqlSession = factory.openSession();
        //获取代理对象
        dao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
       // sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    /**
     * 测试查询一个
     */
    @Test
    public void testFindById() {
        User user1 = dao.findById(58);
        System.out.println(user1);

        sqlSession.close();//释放一级缓存

        SqlSession sqlSession1 = factory.openSession();
        IUserDao dao1 = sqlSession1.getMapper(IUserDao.class);

        User user2 = dao1.findById(58);
        System.out.println(user2);

        sqlSession1.close();

        System.out.println(user1 == user2);
        //一级缓存是相同的


    }


}
