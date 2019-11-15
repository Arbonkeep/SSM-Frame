package com.arbonkeep;

import com.arbonkeep.dao.IUserDao;
import com.arbonkeep.domain.User;
import com.arbonkeep.mybatis.io.Resources;
import com.arbonkeep.mybatis.sqlsession.SqlSession;
import com.arbonkeep.mybatis.sqlsession.SqlSessionFactory;
import com.arbonkeep.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/13 - 19:59
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3. 使用工厂去生成SqlSession对象
        SqlSession session = factory.openSession();
        //4. 使用SqlSession创建dao代理对象
//        IUserDao mapper = session.getMapper(IUserDao.class);
        IUserDao mapper = session.getMapper(IUserDao.class);
        //5. 使用代理对象执行方法
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6. 释放资源
        session.close();
        is.close();
    }
}
