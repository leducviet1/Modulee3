package com.example.thuchanh1808.controllers;

import com.example.thuchanh1808.models.Department;
import com.example.thuchanh1808.services.DepartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create-department")
public class CreateDepartmentServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("form-department.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameDepartment");
        String description = req.getParameter("description");
        Department department = new Department(name, description);

        DepartmentService service = new DepartmentService();
        service.add(department);

        //Phản hồi kết quả
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Đã lưu dữ liệu hành công");
    }
}
