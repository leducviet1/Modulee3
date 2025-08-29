
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách phòng ban</title>
</head>
<body>
<a href="./create-department">Thêm phòng mới</a> <br>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Mô tả </th>
        <td>Thao tác</td>
    </tr>
    <c:forEach items="${departments}" var="department">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td>${department.description}</td>
            <td>
                <a href="edit-department?id=${department.id}">Sửa</a>
                <a href="delete-department?id=${department.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
