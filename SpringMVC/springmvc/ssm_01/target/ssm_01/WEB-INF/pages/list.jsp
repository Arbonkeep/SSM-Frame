<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/6
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询成功</h3>

    <c:forEach items="${accounts}" var="account">
        ${account.toString()}
    </c:forEach>


</body>
</html>
