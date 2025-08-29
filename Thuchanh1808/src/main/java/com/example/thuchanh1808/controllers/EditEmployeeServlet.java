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
import java.util.List;

@WebServlet("/edit-employee")
public class EditEmployeeServlet extends HttpServlet {
    @Override
    //Hiển thị form để người dùng nhập liệu(form-employee.jsp)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //lấy dữ liệu cũ của nhân viên có id đầu vào trên url
        //EmployeeService.getby(id) --> Employee
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.getById(Integer.parseInt(id));
        DepartmentService service = new DepartmentService();
        List<Department> departmentList = service.getAll();

        //Đưa vào trong bộ nhớ Context
        req.setAttribute("employee",employee);
        req.setAttribute("departmentList",departmentList);
        req.getRequestDispatcher("form-employee.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("id");
       String fullName = req.getParameter("full_name");
       String phone = req.getParameter("phone");
       String email = req.getParameter("email");
       String departmentId = req.getParameter("department");
       //Lưu dữ liệu mới vào cơ sở dữ liệu (update)
        Employee employee = new Employee(Integer.parseInt(id),fullName,email,phone,departmentId);
        EmployeeService employeeService = new EmployeeService();
        employeeService.update(employee);
        //Phản hồi thông tin cho người dùng
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Đã cập nhật dữ liệu hành công !");
    }
}
