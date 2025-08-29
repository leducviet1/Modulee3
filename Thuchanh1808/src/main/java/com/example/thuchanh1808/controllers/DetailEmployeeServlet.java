package com.example.thuchanh1808.controllers;

import com.example.thuchanh1808.models.Employee;
import com.example.thuchanh1808.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/detail-employee")
public class DetailEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        EmployeeService service = new EmployeeService();
        service.getById(Integer.parseInt(id));
        Employee detailEmployee = service.getById(Integer.parseInt(id));
        req.setAttribute("detailEmployee",detailEmployee);
        req.getRequestDispatcher("detail-employee.jsp").forward(req, resp);
    }
}
