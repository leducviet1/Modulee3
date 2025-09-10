<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:base>
    <jsp:attribute name="title">Thêm sản phẩm </jsp:attribute>
    <jsp:body>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card p-4 shadow">
                        <h3 class="text-center mb-4">Thao tác với đơn hàng</h3>
                        <form action="" method="post" enctype="multipart/form-data">
                            <div class="mb-3">
                                <label for="nameOrder" class="form-label">Tên sản phẩm</label>
                                <input type="text" class="form-control" id="formGroupExampleInput" name="nameOrder"
                                       placeholder="Tên sản phẩm" value="${order.name}">
                            </div>
                            <div class="mb-3">
                                <label for="priceOrder" class="form-label">Giá sản phẩm</label>
                                <input type="text" class="form-control" id="exampleFormControlInput1" name="priceOrder"
                                       placeholder="Nhập giá" value="${order.price}">
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="imageOrder">Ảnh sản phẩm</label>
                                <c:if test="${not empty order.image}">
                                    <img src="./download?fileName=${order.image}" alt="Ảnh cũ" height="60px" class="mb-2"><br>
                                </c:if>
                                <input type="file" name="imageOrder" class="form-control"> <br>
                            </div>
                            <div class="mb-3">
                                <label for="descriptionOrder" class="form-label">Mô tả chi tiết</label>
                                <input type="text" class="form-control" id="" name="descriptionOrder"
                                       placeholder="Mô tả chi tiết" value="${order.description}">
                            </div>
                            <label for="categoryOrder" class="form-label">Phân loại</label>
                            <select name="categoryOrder" id="" class="form-select">
                                <option value="">Chưa có phân loại</option>
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.id}" ${(category.id == order.categoryId) ? "selected" : ""}>${category.name}</option>
                                </c:forEach>
                            </select>
                            <div class="mb-3">
                            <label for="status" class="form-label">Tình trạng</label>
                            <select name="status" id="" class="form-select">
                                <option>Còn hàng</option>
                                <option>Hết hàng</option>
                            </select>
                            </div>
                            <div class="mb-3">
                            <button type="submit" class="btn btn-primary w-100">Lưu</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</layout:base>

