<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:base>
    <jsp:attribute name="title">Danh sách người dùng</jsp:attribute>
    <jsp:body>
        <div class="container mt-4">
            <h2 class="h4 mb-3">Danh sách người dùng</h2>

            <div class="table-responsive">
                <table class="table table-bordered table-hover align-middle">
                    <thead class="table-dark">
                    <tr>
                        <th>STT</th>
                        <th>Tên người dùng</th>
                        <th>Mật khẩu</th>
                        <th>Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td>
                                <a href="delete-user?id=${user.id}"
                                   class="btn btn-danger btn-sm">Xóa tài khoản</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</layout:base>
