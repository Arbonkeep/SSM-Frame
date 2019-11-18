<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.arbonkeep.dao.IUserDao" %>
<%@ page import="com.arbonkeep.domain.User" %>
<%@ page import="java.util.List" %>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<%
    //1.读取配置
    InputStream is= Resources.getResourceAsStream("SqlMapConfig.xml");
    //2.创建工厂对象
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
    //3.获取sqlSession对象
    SqlSession sqlSession = factory.openSession();
    //4.获取代理对象
    IUserDao dao = sqlSession.getMapper(IUserDao.class);
    //5.执行findAll方法
    List<User> users = dao.findAll();
    for (User user : users) {
        System.out.println(user);
    }
    //6.提交事务，释放资源
    sqlSession.commit();
    sqlSession.close();
    is.close();

    //需要注意的是需要在jsp页面中才能使用JNDI，因为使用JNDI需要经过tomcat服务器，在访问
    //jsp时，需要访问tomcat服务器
%>
</body>
</html>
