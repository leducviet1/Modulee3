
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm phòng ban</title>
</head>
<body>
<form action="" method="post">
    <label for="nameDepartment">Tên phòng ban</label>
    <input type="text" name="nameDepartment" value="${department.name}">
    <label for="description">Mô tả </label>
    <input type="text" name="description" value="${department.description}">
    <button type="submit">Lưu</button>
</form>
</body>
</html>
