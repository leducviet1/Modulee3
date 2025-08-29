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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/create-employee")
public class CreateEmployeeServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lấy danh sách phòng ban từ CSDL
        DepartmentService service = new DepartmentService();
        List<Department> departments = service.getAll();
        req.setAttribute("departments", departments);

        req.getRequestDispatcher("form-employee.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Xử lý input do người dùng nhập vào
        String fullName = req.getParameter("full_name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String department =req.getParameter("department");
        Employee employee ;
        if(department == null || department.equals("")){
            employee = new Employee(fullName,email,phone);
        }else{
            employee = new Employee(fullName,email,phone,Integer.parseInt(department));
        }


        EmployeeService employeeService = new EmployeeService();
        employeeService.add(employee);

        //Phản hồi kết quả
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Đã thêm nhân viên hành công");

    }
}
