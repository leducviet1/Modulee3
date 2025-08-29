package com.example.thuchanh1808.controllers;

import com.example.thuchanh1808.models.Department;
import com.example.thuchanh1808.services.DepartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/departments")
public class ListDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentService departmentService = new DepartmentService();
        List<Department> departments = departmentService.getAll();

        req.setAttribute("departments",departments);
        req.getRequestDispatcher("list-department.jsp").forward(req,resp);
    }
}
