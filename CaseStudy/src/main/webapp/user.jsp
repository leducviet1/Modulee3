
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang User</h1>
<table border="1">
    <tr>
        <th>STT</th>
        <th>Tên sản phẩm</th>
        <th>Giá sản phẩm</th>
        <th>Ảnh</th>
        <th>Mô tả</th>
        <th>Phân loại</th>
        <th>Trạng thái</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><img src="./download?fileName=${product.image}" alt="" height="30px" width="30px"></td>
            <td>${product.description}</td>
            <td>${product.categories_name}</td>
            <td>${product.orderStatus}</td>
            <td>Mua ngay</td>
        </tr>
    </c:forEach>
</table>
<a href="./logout"><button>Đăng xuất</button></a>
</body>
</html>
