
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Home</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">--%>
<%--</head>--%>
<%--<body>--%>

<%--<h1>Trang User</h1>--%>
<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>STT</th>--%>
<%--        <th>Tên sản phẩm</th>--%>
<%--        <th>Giá sản phẩm</th>--%>
<%--        <th>Ảnh</th>--%>
<%--        <th>Mô tả</th>--%>
<%--        <th>Phân loại</th>--%>
<%--        <th>Trạng thái</th>--%>
<%--        <th>Thao tác</th>--%>
<%--    </tr>--%>
<%--    <c:forEach items="${products}" var="product" varStatus="status">--%>
<%--        <tr>--%>
<%--            <td>${status.index + 1}</td>--%>
<%--            <td>${product.name}</td>--%>
<%--            <td>${product.price}</td>--%>
<%--            <td><img src="./download?fileName=${product.image}" alt="" height="30px" width="30px"></td>--%>
<%--            <td>${product.description}</td>--%>
<%--            <td>${product.categories_name}</td>--%>
<%--            <td>${product.orderStatus}</td>--%>
<%--            <td>Mua ngay</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--<a href="./logout"><button>Đăng xuất</button></a>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Trang User</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">

    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                <svg class="bi me-2" width="40" height="32" aria-hidden="true"><use xlink:href="#bootstrap"/></svg>
                <span class="fs-4">Home</span>
            </a>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="./list-product" class="nav-link ${fn:contains(pageContext.request.requestURI, '/orders') ? 'active' : ''}"
                                        aria-current="page">Danh sách sản phẩm</a></li>
                <li class="nav-item"><a href="./profile-user" class="nav-link"><button type="button" class="btn btn-danger">${user.username}</button></a></li>
                <li class="nav-item"><a href="./logout" class="nav-link"><button type="button" class="btn btn-primary">Đăng xuất</button></a></li>
            </ul>
        </header>
    </div>

    <div class="container mt-5">
        <h1 class="mb-4">Danh sách sản phẩm</h1>
        <ul class="row list-unstyled">
            <c:forEach items="${products}" var="product">
                <li class="col-sm-6 col-md-4 col-lg-3 mb-4">
                    <!-- Card sản phẩm -->
                    <div class="card h-100 shadow-sm">
                        <c:if test="${not empty product.image}">
                            <img src="./download?fileName=${product.image}" class="card-img-top" alt="${product.name}">
                        </c:if>
                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text text-truncate">${product.description}</p>
                            <p class="card-text"><strong>Giá:</strong> ${product.price}</p>
                            <p class="card-text">
                                <strong>Phân loại:</strong> ${product.categories_name}
                            </p>
                            <span class="badge
                            ${product.orderStatus == 'Còn hàng' ? 'bg-success' : 'bg-secondary'}">
                                    ${product.orderStatus}
                            </span>
                            <div class="mt-auto">
                                <button class="btn btn-primary w-100 mt-2">Mua ngay</button>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>

