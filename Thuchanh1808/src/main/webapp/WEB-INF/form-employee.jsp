
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--cách 1: dùng if-else cho action--%>
<%--cách 2: k để gì, tùy theo cái nó gửi--%>
<form action="" method="post">
    <label for="full_name">Họ tên</label>
    <input type="text" name="full_name" value="${employee.fullName}"><br>
    <label for="email">Email</label>
    <input type="text" name="email" value="${employee.email}"><br>
    <label for="phone">Số điện thoại</label>
    <input type="text" name="phone" value="${employee.phone}"> <br>
    <label for="department">
        <select name="department" >
            <option value="">Chưa có phòng ban</option>
            <c:forEach var="department" items="${departmentList}">
                <option value="${department.id}" ${(department.id == employee.departmentId) ? "selected" : ""}>${department.name}</option>
            </c:forEach>
        </select>
        <br>
    </label>
    <button type="submit">Lưu</button>
</form>

</body>
</html>
