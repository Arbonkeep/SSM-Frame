package com.arbonkeep.test;

import com.arbonkeep.dao.IRoleDao;
import com.arbonkeep.domain.Role;
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
 * @date 2019/11/18 - 13:54
 */
public class RoleTest {
    private InputStream is;
    private SqlSession sqlSession;
    private IRoleDao dao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlSession工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取sqlSession对象
        sqlSession = factory.openSession();
        //4.获取代理对象dao
        dao = sqlSession.getMapper(IRoleDao.class);
    }

    @After
    public void destroy() throws IOException {
        //6.提交事务
        sqlSession.commit();
        //7.关闭资源
        sqlSession.close();
        is.close();
    }

    /**
     *查询角色获取角色下所属的用户信息
     */
    @Test
    public void testFindAll() {
        List<Role> roles = dao.findAll();

        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

}
