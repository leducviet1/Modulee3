
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thao tác với đơn hàng</title>
</head>
<body>

<form action="" method="post" enctype="multipart/form-data">
    <label for="nameOrder">Tên sản phẩm</label>
    <input type="text" name="nameOrder" value="${order.name}" > <br>
    <label for="priceOrder">Giá sản phẩm</label>
    <input type="text" name="priceOrder" id="" value="${order.price}"> <br>
    <label for="imageOrder">Ảnh sản pham</label>
<%--    <input type="file" name="imageOrder" id=""value="${order.image}"> <br>--%>
    <!-- Hiển thị ảnh cũ -->
    <c:if test="${not empty order.image}">
        <img src="./download?fileName=${order.image}" alt="Ảnh cũ" height="60px"><br>
    </c:if>
    <!-- Input để chọn ảnh mới -->
    <input type="file" name="imageOrder"> <br>
    <label for="descriptionOrder">Mô tả chi tiết</label>
    <input type="text" name="descriptionOrder" id="" value="${order.description}"> <br>
    <label for="categoryOrder">Phân loại</label>
    <select name="categoryOrder" id="">
        <option value="">Chưa có phân loại</option>
        <c:forEach items="${categoryList}" var="category">
            <option value="${category.id}" ${(category.id == order.categoryId) ? "selected" : ""}>${category.name}</option>
        </c:forEach>
    </select>
    <label for="status">Tình trạng</label>
    <select name="status" id="" >
        <option >Còn hàng</option>
        <option >Hết hàng</option>
    </select>
    <button type="submit">Lưu</button>
</form>
</body>
</html>
