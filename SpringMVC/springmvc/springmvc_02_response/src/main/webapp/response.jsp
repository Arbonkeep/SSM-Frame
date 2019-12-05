<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/4
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%--引入jquery资源--%>
    <script src="js/jquery.min.js"></script>

    <script>
        //加载页面，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //alert("Hello");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"lisi","password":"123","age":25}',
                    dataType:"json",
                    type:"post",
                    sucess:function(data) {
                        //接收到data服务端响应的json数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });


    </script>

</head>
<body>

    <%--演示返回值是字符串--%>
    <a href="user/testString">测试字符串</a>

    <br/>
    <%--演示返回值是void--%>
    <a href="user/testVoid">测试void</a>

    <br/>
    <%--演示返回值是ModelAndView--%>
    <a href="user/testModelAndView">测试ModelAndView</a>

    <br/>
    <%--测试使用关键字--%>
    <a href="user/testForwardOrRedirect">测试使用关键字</a>

    <br/>
    <button id="btn">发送ajax请求</button>

</body>
</html>
