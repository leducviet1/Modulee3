
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thao tác với loại sản phaarm</title>
</head>
<body>
<form action="" method="post">
    <label for="nameCategory">Tên loại sản phẩm</label>
    <input type="text" name="nameCategory" id="" value="${category.name}">
    <label for="descriptionCategory">Mô tả </label>
    <input type="text" name="descriptionCategory" id="" value="${category.description}">
    <!-- hiển thị lỗi ngay dưới ô nhập -->
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>

    <br>
    <button type="submit">Lưu</button>
</form>
</body>
</html>
