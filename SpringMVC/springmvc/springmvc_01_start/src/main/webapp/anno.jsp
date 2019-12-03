<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/3
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="anno/testRequestParam?name=zhangsan">测试注解RequestParam</a>

<br/>

    <%--用于测试RequestBody注解--%>
    <form action="anno/testRequestBody" method="post">
        姓名：<input type="text" name="username"> <br/>
        年龄：<input type="text" name="age"> <br/>
        <input type="submit" value="提交">
    </form>

    <br/>

    <%--测试PathVariable--%>
    <a href="anno/testPathVariable/6">测试注解PathVariable</a>


    <%--用于测试RequestHeader注解--%>
    <form action="anno/testRequestHeader" method="post">
        姓名：<input type="text" name="username"> <br/>
        年龄：<input type="text" name="age"> <br/>
        <input type="submit" value="提交">
    </form>


    <br/>

    <%--测试PCookieValue--%>
    <a href="anno/testCookieValue">测试注解CookieValue</a>

    <br/>

    <%--用于测试ModelAttribute注解--%>
    <form action="anno/testModelAttribute" method="post">
        姓名：<input type="text" name="name"> <br/>
        年龄：<input type="text" name="age"> <br/>
        <input type="submit" value="提交">
    </form>

    <%--用以测试SessionAtttributes--%>
    <a href="anno/testSessionAttributes">测试注解SessionAtttributes</a>
    <br/>

    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <br/>

    <a href="anno/deleteSessionAttributes">deleteSessionAttributes</a>


</body>
</html>
