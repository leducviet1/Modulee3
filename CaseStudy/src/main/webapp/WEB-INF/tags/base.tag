<%@ tag description="This is base layout of web application" pageEncoding="UTF-8" %>
<%@ attribute name="title" fragment="true" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="title"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
            <svg class="bi me-2" width="40" height="32" aria-hidden="true"><use xlink:href="#bootstrap"/></svg>
            <span class="fs-4">Admin Orders</span>
        </a>

        <ul class="nav nav-pills">
            <li class="nav-item"><a href="./orders" class="nav-link ${fn:contains(pageContext.request.requestURI, '/orders') ? 'active' : ''}"
                                    aria-current="page">Danh sách sản phẩm</a></li>
            <li class="nav-item"><a href="./categories" class="nav-link ${fn:contains(pageContext.request.requestURI, '/categories') ? 'active' : ''}">Danh sách thể loại</a></li>
            <li class="nav-item"><a href="./list-user" class="nav-link">Quản lý User</a></li>
            <li class="nav-item"><a href="#" class="nav-link"><button type="button" class="btn btn-danger">${user.username}</button></a></li>
            <li class="nav-item"><a href="./logout" class="nav-link"><button type="button" class="btn btn-primary">Đăng xuất</button></a></li>
        </ul>
    </header>
    <jsp:doBody/>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>