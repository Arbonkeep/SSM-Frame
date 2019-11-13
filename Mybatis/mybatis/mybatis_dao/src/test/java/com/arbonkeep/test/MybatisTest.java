package com.arbonkeep.test;

import com.arbonkeep.dao.impl.UserDaoImpl;
import com.arbonkeep.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/13 - 16:43
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1. 读取资源
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建工厂对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3. 创建IUerDao对象
        UserDaoImpl dao = new UserDaoImpl(factory);
        //4.调用方法
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //5. 关闭资源
        is.close();

    }

}
