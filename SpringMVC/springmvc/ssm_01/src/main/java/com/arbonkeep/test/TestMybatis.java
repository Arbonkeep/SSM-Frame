package com.arbonkeep.test;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/12/6 - 14:39
 * 此类需要sqlMapConfig.xml的支持，已经删除
 */
public class TestMybatis {

    //测试查询所有
    @Test
    public void test1() throws Exception {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取sqlSession对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        //获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        //调用方法执行
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        //释放资源
        sqlSession.close();
        is.close();

    }

    //测试save
    @Test
    public void test2() throws Exception {
        //1.加载配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.获取sqlSession对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        //3.获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);

        //创建Account
        Account account = new Account();
        account.setName("王五");
        account.setMoney(1000);
        //4.调用方法
        dao.saveAccount(account);
        //提交事务
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
        is.close();


    }
}
