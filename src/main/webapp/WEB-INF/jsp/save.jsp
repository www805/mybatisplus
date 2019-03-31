<%--
  Created by IntelliJ IDEA.
  User: 庄先生
  Date: 2019/3/31
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="/save" method="post">
    姓名：<input type="text" name="name"><br/>
    地址：<input type="text" name="address"><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
