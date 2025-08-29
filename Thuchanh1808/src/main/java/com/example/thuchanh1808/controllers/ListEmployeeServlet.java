package com.example.thuchanh1808.controllers;

import com.example.thuchanh1808.models.Department;
import com.example.thuchanh1808.models.Employee;
import com.example.thuchanh1808.services.DepartmentService;
import com.example.thuchanh1808.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class ListEmployeeServlet extends HttpServlet {
    //Hiển thị toàn bộ nhân viên
    //k cần tham số đầu vào
    //thực thi sql từ mysql
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nếu cần tìm kiếm thì mới dùng đến
        String q = req.getParameter("q");
        String sortBy = req.getParameter("sortBy");
        String departmentId = req.getParameter("departmentId");
        //Thực thi SQL từ MySQL
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.getAll(q, sortBy, departmentId);
        //Hiển thị danh sách qua html
        //Lấy danh sách phòng ban từ CSDL
        DepartmentService departmentService = new DepartmentService();
        List<Department>departmentList = departmentService.getAll();
        //đưa vào bộ nhớ
        req.setAttribute("employees",employees);
        req.setAttribute("departmentId",departmentId);
        req.setAttribute("departmentList",departmentList);
        //chuyển qua jsp
        req.getRequestDispatcher("list-employees.jsp").forward(req,resp);
    }
}
