<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<layout:base>
    <jsp:attribute name="title">Danh sách sản phẩm</jsp:attribute>
    <jsp:body><p></p>
        <div class="d-flex justify-content-between align-items-start mb-4">
        <button type="button" class="btn btn-info">
            <a href="./create-order" class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover">Thêm sản phẩm mới</a>
        </button>
<%--        Lọc sản phẩm theo phân loại:--%>
<%--        <form action="" method="get" class="row g-3 align-items-center mb-4">--%>
<%--            <select name="categoryId">--%>
<%--                <option value="">Tất cả </option>--%>
<%--                <c:forEach items="${categories}" var="category">--%>
<%--                <option value="${category.id}"--%>
<%--                    ${(category.id == categoryId) ? "selected" : ""}>--%>
<%--                        ${category.name}--%>
<%--                </option>--%>
<%--                    </c:forEach>--%>
<%--            </select>--%>
<%--            <label>Sắp xếp theo:</label>--%>
<%--            <select name="sortBy">--%>
<%--                <option value="">-- Mặc định --</option>--%>
<%--                <option value="price" <c:if test="${sortBy == 'price'}">selected</c:if>>Giá</option>--%>
<%--                <option value="name" <c:if test="${sortBy == 'name'}">selected</c:if>>Tên sản phẩm</option>--%>
<%--                <option value="id" <c:if test="${sortBy == 'id'}">selected</c:if>>Mã sản phẩm</option>--%>
<%--            </select>--%>

<%--            <select name="sortOrder">--%>
<%--                <option value="">Mặc định</option>--%>
<%--                <option value="ASC" <c:if test="${sortOrder == 'ASC'}">selected</c:if>>Tăng dần</option>--%>
<%--                <option value="DESC" <c:if test="${sortOrder == 'DESC'}">selected</c:if>>Giảm dần</option>--%>
<%--            </select>--%>

<%--            <button type="submit">Áp dụng</button>--%>

<%--        </form>--%>
        <form action="" method="get" class="border p-3 rounded bg-light">

            <!-- Chọn phân loại -->
            <div class="row g-3 mb-3">
                <div class="col">
                <label for="categoryId" class="form-label mb-0">Phân loại:</label>
                <select name="categoryId" id="categoryId" class="form-select">
                    <option value="">Tất cả</option>
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}" <c:if test="${category.id == categoryId}">selected</c:if>>
                                ${category.name}
                        </option>
                    </c:forEach>
                </select>
                </div>


            <!-- Chọn sắp xếp theo -->
            <div class="col">
                <label for="sortBy" class="form-label mb-0">Sắp xếp theo:</label>
                <select name="sortBy" id="sortBy" class="form-select">
                    <option value="">-- Mặc định --</option>
                    <option value="price" <c:if test="${sortBy == 'price'}">selected</c:if>>Giá</option>
                    <option value="name" <c:if test="${sortBy == 'name'}">selected</c:if>>Tên sản phẩm</option>
                    <option value="id" <c:if test="${sortBy == 'id'}">selected</c:if>>Mã sản phẩm</option>
                </select>
            </div>

            <!-- Chọn thứ tự -->
            <div class="col">
                <label for="sortOrder" class="form-label mb-0">Thứ tự:</label>
                <select name="sortOrder" id="sortOrder" class="form-select">
                    <option value="">Mặc định</option>
                    <option value="ASC" <c:if test="${sortOrder == 'ASC'}">selected</c:if>>Tăng dần</option>
                    <option value="DESC" <c:if test="${sortOrder == 'DESC'}">selected</c:if>>Giảm dần</option>
                </select>
            </div>

            <!-- Nút áp dụng -->
            <div class="d-flex justify-content-end gap-2">
                <button type="submit" class="btn btn-primary">Áp dụng</button>
                <a href="./orders" class="btn btn-secondary">Reset</a>
            </div>
            </div>
        </form>
        </div>

        <%--            <label for="sortOrder">Sắp xếp giá:</label>--%>
<%--            <select name="sortOrder" id="sortOrder">--%>
<%--                <option value="">Mặc định</option>--%>
<%--                <option value="ASC" ${sortOrder == 'ASC' ? 'selected' : ''}>Tăng dần</option>--%>
<%--                <option value="DESC" ${sortOrder == 'DESC' ? 'selected' : ''}>Giảm dần</option>--%>
<%--            </select>--%>
<%--            <button type="submit">Áp dụng</button>--%>

        <h2>Danh sách sản phẩm</h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Tên sản phẩm</th>
                <th scope="col">>Giá sản phẩm</th>
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
                    <button type="button" class="btn btn-danger"><a href="edit-order?id=${order.id}" class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover">Sửa</a></button>
                    <button type="button" class="btn btn-success"><a href="delete-order?id=${order.id}" class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover">Xóa</a></button>

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