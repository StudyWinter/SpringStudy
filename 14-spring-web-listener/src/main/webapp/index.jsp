<%--
  Created by IntelliJ IDEA.
  User: songdongdong
  Date: 2020/8/7
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

<p>提交参数</p>
<form action="regservlet" method="post">
    姓名：<input type="text" name="name"> <br>
    年龄：<input type="text" name="age"> <br>
    <input type="submit" value="注册">
</form>

</body>
</html>
