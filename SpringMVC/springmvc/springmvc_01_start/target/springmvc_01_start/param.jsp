<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/2
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--请求参数绑定,拼接两个请求参数--%>
    <a href="param/testParam?username=aaa&password=123">请求参数绑定</a>

    <%--请求参数绑定，将请求参数封装在javabean对象中--%>
    <%--<form action="param/testParam2" method="post">--%>
        <%--姓名：<input type="text" name="username"/> <br/>--%>
        <%--密码：<input type="text" name="password"/> <br/>--%>
        <%--金额：<input type="text" name="money"/> <br/>--%>
        <%--用户姓名：<input type="text" name="user.name"/> <br/>--%>
        <%--用户年龄：<input type="text" name="user.age"/> <br/>--%>
        <%--<input type="submit" value="提交">--%>
    <%--</form>--%>


    <%--请求参数绑定，将请求参数封装Account中，类中包含list和map集合--%>
    <form action="param/testParam2" method="post">
        姓名：<input type="text" name="username"/> <br/>
        密码：<input type="text" name="password"/> <br/>
        金额：<input type="text" name="money"/> <br/>
        <%--将这组数据封装到user对象中,然后将user对象封装到list集合中--%>
        用户姓名：<input type="text" name="list[0].name"/> <br/>
        用户年龄：<input type="text" name="list[0].age"/> <br/>
        <%--将这组数据封装到user对象中,然后将user对象封装到map集合中--%>
        用户姓名：<input type="text" name="map['one'].name"/> <br/>
        用户年龄：<input type="text" name="map['one'].age"/> <br/>
        <input type="submit" value="提交">
    </form>

</body>
</html>
