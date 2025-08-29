package com.example.thuchanh1808.controllers;

import com.example.thuchanh1808.models.Department;
import com.example.thuchanh1808.services.DepartmentService;
import com.example.thuchanh1808.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit-department")
public class EditDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DepartmentService service = new DepartmentService();
        Department department=service.getById(Integer.parseInt(id));

        req.setAttribute("department", department);
        req.getRequestDispatcher("form-department.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id  = req.getParameter("id");
        String name = req.getParameter("nameDepartment");
        String description = req.getParameter("description");
        Department department = new Department(Integer.parseInt(id),name,description);
        DepartmentService service = new DepartmentService();
        service.update(department);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Đã cập nhật dữ liệu hành công !");

    }
}
