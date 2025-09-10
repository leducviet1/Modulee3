<%--<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<layout:base>--%>
<%--    <jsp:attribute name="title">Danh sách các loại sản phẩm</jsp:attribute>--%>
<%--    <jsp:body>--%>
<%--        <a href="./create-category">Thêm loại sản phẩm mới</a>--%>
<%--        <table border="1">--%>
<%--            <tr>--%>
<%--                <th>Id</th>--%>
<%--                <th>Tên loại sản phẩm</th>--%>
<%--                <th>Mô tả</th>--%>
<%--                <th>Thao tác</th>--%>
<%--            </tr>--%>
<%--            <c:forEach items="${categories}" var="category">--%>
<%--                <tr>--%>
<%--                    <td>${category.id}</td>--%>
<%--                    <td>${category.name}</td>--%>
<%--                    <td>${category.description}</td>--%>
<%--                    <td>--%>
<%--                        <a href="edit-category?id=${category.id}">Sửa</a>--%>
<%--                        <a href="delete-category?id=${category.id}">Xóa</a>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>

<%--        </table>--%>
<%--    </jsp:body>--%>
<%--</layout:base>--%>
<%--</html>--%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:base>
    <jsp:attribute name="title">Danh sách các loại sản phẩm</jsp:attribute>
    <jsp:body>
        <div class="container mt-4">

            <div class="d-flex justify-content-between align-items-center mb-3">
                <h2 class="h4">Danh sách loại sản phẩm</h2>
                <a href="./create-category" class="btn btn-success">Thêm loại sản phẩm mới</a>
            </div>

            <div class="table-responsive">
                <table class="table table-bordered table-hover align-middle">
                    <thead class="table-dark">
                    <tr>
                        <th>Id</th>
                        <th>Tên loại sản phẩm</th>
                        <th>Mô tả</th>
                        <th>Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${categories}" var="category">
                        <tr>
                            <td>${category.id}</td>
                            <td>${category.name}</td>
                            <td>${category.description}</td>
                            <td>
                                <a href="edit-category?id=${category.id}" class="btn btn-primary btn-sm me-1">Sửa</a>
                                <a href="delete-category?id=${category.id}" class="btn btn-danger btn-sm">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </jsp:body>
</layout:base>

