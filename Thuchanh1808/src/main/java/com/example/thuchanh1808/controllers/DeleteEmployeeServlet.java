package com.example.thuchanh1808.controllers;

import com.example.thuchanh1808.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete-employee")

public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("delete-employee.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //input: ly id



        String id = req.getParameter("id");
        String confirm = req.getParameter("confirm");
        if(confirm.equals("yes")){
            EmployeeService service = new EmployeeService();
            int result = service.delete(Integer.parseInt(id));
            //output: phản hồi kết quả theo format html
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<html><head><title>Delete Employee</title></head><body>");
            if(result>0){
                out.println("<h1>Đã xóa nhân viên có id = " + id +" thành công</h1>");
            }else {
                out.println("<h1>Thao tác xóa thất bại</h1>");
            }
            out.println("</body></html>");
        }else {
            resp.sendRedirect("./employees");
        }
        //csdl: sửa employeeService

    }
}
