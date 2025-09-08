<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<layout:base>
    <jsp:attribute name="title">Danh sách các loại sản phẩm</jsp:attribute>
    <jsp:body>
        <a href="./create-category">Thêm loại sản phẩm mới</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Tên loại sản phẩm</th>
                <th>Mô tả</th>
                <th>Thao tác</th>
            </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <td>
                        <a href="edit-category?id=${category.id}">Sửa</a>
                        <a href="delete-category?id=${category.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </jsp:body>
</layout:base>




</html>
