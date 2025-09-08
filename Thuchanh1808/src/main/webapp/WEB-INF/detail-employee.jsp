
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>
    <head>
        <title>Chi tiết nhân viên</title>
    </head>
    <body>
    <h2>Thông tin chi tiết nhân viên</h2>
    <table border="1">

        <tr>
            <th>ID</th>
            <th>Full name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Department</th>
        </tr>
        <c items="${detailEmployee}" var="detailEmployee">
            <tr>
                <td>${detailEmployee.id}</td>
                <td>${detailEmployee.fullName}</td>
                <td>${detailEmployee.email}</td>
                <td>${detailEmployee.phone}</td>
                <td>${detailEmployee.departmentName}</td>
            </tr>
        </c>
    </table>
    </body>
    </html>
