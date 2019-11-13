package com.arbonkeep.test;

import com.arbonkeep.dao.IUserDao;
import com.arbonkeep.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/13 - 14:29
 * 入门案例
 *  注意：在运行之前需要在配置文件的查询语句中指明结果集
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1. 读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);

        //3. 使用工厂创建Session对象
        SqlSession session = factory.openSession();

        //4.使用session创建代理对象dao
        IUserDao dao = session.getMapper(IUserDao.class);

        //5.使用代理对象调用方法
        List<User> user = dao.findAll();

        for (User user1 : user) {
            System.out.println(user1);
        }

        //6.关闭资源
        session.close();
        is.close();

    }

}
