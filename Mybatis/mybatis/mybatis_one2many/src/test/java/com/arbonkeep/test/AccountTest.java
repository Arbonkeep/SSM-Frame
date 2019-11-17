package com.arbonkeep.test;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import com.arbonkeep.domain.AccountUser;
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
 * @date 2019/11/17 - 16:25
 */
public class AccountTest {
    private InputStream is;
    private SqlSession sqlSession;
    private AccountDao dao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(is);
        //3.获取sqlSession对象
        sqlSession = factory.openSession();
        //4.获取AccountDao的代理对象
        dao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        //5.提交事务
        sqlSession.commit();

        //6.释放资源
        sqlSession.close();
        is.close();
    }

    /**
     * 测试查询所有账户
     */
    @Test
    public void testFindAll() {
        //1.使用代理对象调用findAll方法
        List<Account> accounts = dao.findAll();
        //2.遍历
        for (Account account : accounts) {
            System.out.println("-------------一个用户的信息------------");
            System.out.println(account);
            System.out.println(account.getUser());//获取user信息
        }
    }

    /**
     * 测试查询所有，并包含用户名以及地址信息
     */
    @Test
    public void testFindAllAccount() {
        //使用代理对象调用方法
        List<AccountUser> accounts = dao.findAllAccount();

        for (AccountUser account : accounts) {
            System.out.println(account);
        }
    }


}
