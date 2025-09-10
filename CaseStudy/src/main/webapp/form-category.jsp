<%--<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<layout:base>--%>
<%--    <jsp:body>--%>
<%--        <form action="" method="post">--%>
<%--            <label for="nameCategory">Tên loại sản phẩm</label>--%>
<%--            <input type="text" name="nameCategory" id="" value="${category.name}">--%>
<%--            <label for="descriptionCategory">Mô tả </label>--%>
<%--            <input type="text" name="descriptionCategory" id="" value="${category.description}">--%>
<%--            <!-- hiển thị lỗi ngay dưới ô nhập -->--%>
<%--            <c:if test="${not empty error}">--%>
<%--                <p style="color:red">${error}</p>--%>
<%--            </c:if>--%>

<%--            <br>--%>
<%--            <button type="submit">Lưu</button>--%>
<%--        </form>--%>
<%--    </jsp:body>--%>
<%--</layout:base>--%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:base>
    <jsp:body>
        <div class="container d-flex justify-content-center align-items-center min-vh-100">
            <div class="col-md-6">
                <div class="card p-4 shadow">
                    <h3 class="text-center mb-4">Thêm / Sửa loại sản phẩm</h3>
                    <form action="" method="post">
                        <div class="mb-3">
                            <label for="nameCategory" class="form-label">Tên loại sản phẩm</label>
                            <input type="text" name="nameCategory" id="nameCategory"
                                   class="form-control" value="${category.name}">
                        </div>

                        <div class="mb-3">
                            <label for="descriptionCategory" class="form-label">Mô tả</label>
                            <input type="text" name="descriptionCategory" id="descriptionCategory"
                                   class="form-control" value="${category.description}">
                        </div>

                        <c:if test="${not empty error}">
                            <p class="text-danger">${error}</p>
                        </c:if>

                        <button type="submit" class="btn btn-primary w-100 mt-3">Lưu</button>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</layout:base>

