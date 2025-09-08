
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>
<a href="./create-employee">Thêm mới nhân viên</a> <br> <br>
Lọc nhân viên theo phòng ban:
<form action="" method="get">
    <select name="departmentId" >
        <option value="">Tất cả phòng ban</option>
    <c:forEach items="${departmentList}" var="department">
        <option value="${department.id}"
            ${(department.id == departmentId) ? "selected" : ""}>
                ${department.name}
    </c:forEach>
    </select>
    <button type="submit">Lọc</button>
</form>
<table border="1">
    <tr>
        <td>ID</td>
        <td><a href="./employees?sortBy=full_name">Full Name</a></td>
        <td><a href="./employees?sortBy=email">Email</a></td>
        <td><a href="./employees?sortBy=phone">Phone</a></td>
        <td>Department</td>
        <td>Thao tác</td>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td><a href="./detail-employee?id=${employee.id}">${employee.fullName}</a></td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td>${employee.departmentName}</td>
            <td>
                <a href="edit-employee?id=${employee.id}">Sửa</a>
                <a href="delete-employee?id=${employee.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
