<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 庄先生
  Date: 2019/3/31
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body  >

<div >

    <table border="1" style="margin: 0 auto;" cellspacing="0" cellpadding="0">
        <caption>员工管理系统</caption>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>address</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="item" varStatus="vs">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.address}</td>
                <td width="40"><a href="/del/${item.id}">删除</a></td>

            </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
                <a href="/save">添加用户</a>
            </td>
        </tr>


    </table>

</div>

</body>
</html>
