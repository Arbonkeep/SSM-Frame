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
 * @date 2019/11/19 - 16:42
 */
public class TestAnnotation {
    /**
     * 测试查询所有
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //4.获取代理对象dao
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        //5.调用方法执行
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.关闭资源
        sqlSession.close();
        is.close();


    }
}
