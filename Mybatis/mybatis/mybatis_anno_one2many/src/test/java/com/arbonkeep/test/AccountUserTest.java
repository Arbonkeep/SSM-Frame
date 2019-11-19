package com.arbonkeep.test;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
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
 * @date 2019/11/19 - 19:04
 */
public class AccountUserTest {
    private InputStream is;
    private SqlSession sqlSession;
    private AccountDao dao;

    @Before
    public void init() throws IOException {
        //读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //获取sqlSession对象
        sqlSession = factory.openSession();
        //获取代理对象
        dao = sqlSession.getMapper(AccountDao.class);
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
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println("---------每个账户的信息---------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
