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

/**
 * @author arbonkeep
 * @date 2019/11/19 - 15:28
 * 测试一对多的关系
 */
public class SecondLevelCacheTest {
    private InputStream is;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlSession工厂对象
        factory = new SqlSessionFactoryBuilder().build(is);

    }

    @After
    public void destroy() throws IOException {
        is.close();
    }

    /**
     * 演示一级缓存
     */
    @Test
    public void testSecondLevelCache() {
        SqlSession sqlSession = factory.openSession();
        IUserDao dao1 = sqlSession.getMapper(IUserDao.class);
        User user1 = dao1.selectById(41);
        System.out.println(user1);

        sqlSession.close();//一级缓存消失

        SqlSession sqlSession2 = factory.openSession();
        IUserDao dao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = dao2.selectById(41);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1 == user2);

    }

}
