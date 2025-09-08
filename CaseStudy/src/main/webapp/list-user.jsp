<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/9/2025
  Time: 5:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách người dùng</title>
</head>
<body>
<table border="1">
    <tr>
        <th>STT</th>
        <th>Tên người dùng</th>
        <th>Mật khẩu</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td><a href="delete-user?id=${user.id}">Xóa tài khoản</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
