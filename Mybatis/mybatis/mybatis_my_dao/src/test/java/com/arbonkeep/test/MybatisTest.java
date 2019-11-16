package com.arbonkeep.test;

import com.arbonkeep.dao.IUserDao;
import com.arbonkeep.dao.impl.UserDaoImpl;
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
        //3.使用工厂对象创建dao对象
        dao = new UserDaoImpl(factory);


    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws IOException {
        //5.关闭资源
        is.close();
    }

    /**
     * 测试查询所有
     * @throws IOException
     */
    @Test
    public void testFindAll() throws IOException {

        //4.使用dao对象执行方法
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * 测试保存数据（添加一条数据）
     */
    @Test
    public void testSave() {
        //创建User对象
        User user = new User();
        user.setUsername("zhangsan ");
        user.setAddress("南昌市东湖区");
        user.setSex("男");
        user.setBirthday(new Date());

        System.out.println("在保存之前。。。" + user);
        //5.使用代理对象调用save方法
        dao.save(user);

        System.out.println("在保存之后。。。" + user);



    }

    /**
     * 更新用户数据
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(49);
        user.setUsername("zhangsan");
        user.setAddress("南昌市西湖区");
        user.setSex("男");
        user.setBirthday(new Date());

        dao.update(user);

    }

    /**
     * 测试删除数据
     */
    @Test
    public void testDelete() {
        //使用代理对象调用删除操作
        dao.delete(51);
    }

    /**
     * 查询一个
     */
    @Test
    public void testselectById() {
        //使用代理对象查询
        User user = dao.selectById(52);
        System.out.println(user);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testselectByName() {
        //使用dao对象进行模糊查询
        List<User> users = dao.selectByName("%王%");//这种方式使用的是ParameterStatement的参数占位符
        //List<User> users = dao.selectByName("王");//这种方式使用的是Statement对象的字符串拼接Sql

        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * 测试查询总的记录条数
     */
    @Test
    public void testTotal() {
        //调用方法

        int total = dao.findTotal();
        System.out.println(total);
    }




}
