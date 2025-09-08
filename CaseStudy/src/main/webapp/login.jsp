
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<body>
<%--<form action="./register" method="post"><label>Username:</label>--%>
<%--    <input type="text" name="username" required/>--%>
<%--    <label>Password:</label>--%>
<%--    <input type="password" name="password" required/>--%>
<%--    <button type="submit">Đăng ký</button>--%>
<%--</form>--%>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card shadow">
                <div class="card-body">
                    <h3 class="card-title text-center mb-4">Đăng Nhập</h3>
                    <form action="./login" method="post">
                        <div class="mb-3">
                            <label for="loginEmail" class="form-label">Tên đăng nhập</label>
                            <input type="text" class="form-control" id="loginEmail" name="username" placeholder="Nhập tên đăng nhập">
                        </div>
                        <div class="mb-3">
                            <label for="loginPassword" class="form-label">Mật khẩu</label>
                            <input type="password" class="form-control" id="loginPassword" name="password" placeholder="Nhập mật khẩu">
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Đăng Nhập</button>
                        </div>
                    </form>
                    <p class="text-center mt-3">
                        Chưa có tài khoản? <a href="./register">Đăng ký</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
