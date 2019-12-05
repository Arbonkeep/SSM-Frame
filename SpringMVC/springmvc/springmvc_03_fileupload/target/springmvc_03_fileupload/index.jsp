<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/4
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>使用传统方式文件上传</h3>

    <form action="user/fileController1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="开始上传"/>

    </form>

    <h3>使用springmvc方式文件上传</h3>

    <form action="user/fileController2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="开始上传"/>

    </form>

    <h3>跨服务器文件上传</h3>

    <form action="user/fileController3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="开始上传"/>

    </form>


</body>
</html>
