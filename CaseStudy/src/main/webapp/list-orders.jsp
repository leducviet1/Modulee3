<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<layout:base>
    <jsp:attribute name="title">Danh sách sản phẩm</jsp:attribute>
    <jsp:body><p></p>
        <button type="button" class="btn btn-info"><a href="./create-order"
                                                      class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover">Thêm
            sản phẩm mới</a></button>
        <h2>Danh sách sản phẩm</h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Tên sản phẩm</th>
                <th scope="col">Giá sản phẩm</th>
                <th scope="col">Ảnh</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Phân loại</th>
                <th scope="col">Trạng thái</th>
                <th scope="col">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order">
            <tr>
                <th scope="row">${order.id}</th>
                <td>${order.name}</td>
                <td>${order.price}</td>
                <td><img src="./download?fileName=${order.image}" alt="" height="100px" width="100px"></td>
                <td>${order.description}</td>
                <td>${order.categories_name}</td>
                <td>${order.orderStatus}</td>
                <td>
                    <a href="edit-order?id=${order.id}">Sửa</a>
                    <a href="delete-order?id=${order.id}">Xóa</a>
                </td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
        <%--        <table border="1">--%>
        <%--            <tr>--%>
        <%--                <th>Id</th>--%>
        <%--                <th>Tên sản phẩm</th>--%>
        <%--                <th>Giá sản phẩm</th>--%>
        <%--                <th>Ảnh</th>--%>
        <%--                <th>Mô tả</th>--%>
        <%--                <th>Phân loại</th>--%>
        <%--                <th>Trạng thái</th>--%>
        <%--                <th>Thao tác</th>--%>
        <%--            </tr>--%>
        <%--            <c:forEach items="${orders}" var="order">--%>
        <%--                <tr>--%>
        <%--                    <td>${order.id}</td>--%>
        <%--                    <td>${order.name}</td>--%>
        <%--                    <td>${order.price}</td>--%>
        <%--                    <td><img src="./download?fileName=${order.image}" alt="" height="30px" width="30px"></td>--%>
        <%--                    <td>${order.description}</td>--%>
        <%--                    <td>${order.categories_name}</td>--%>
        <%--                    <td>${order.orderStatus}</td>--%>
        <%--                    <td>--%>
        <%--                        <a href="edit-order?id=${order.id}">Sửa</a>--%>
        <%--                        <a href="delete-order?id=${order.id}">Xóa</a>--%>
        <%--                    </td>--%>
        <%--                </tr>--%>
        <%--            </c:forEach>--%>
        <%--        </table>--%>
    </jsp:body>
</layout:base>