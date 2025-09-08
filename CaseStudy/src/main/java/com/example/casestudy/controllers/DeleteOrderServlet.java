package com.example.casestudy.controllers;

import com.example.casestudy.services.OrdersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete-order")
public class DeleteOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        OrdersService service = new OrdersService();
        int row = service.deleteById(Integer.parseInt(id));
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Delete Department</title></head><body>");
        if(row>0){
            out.println("<h1>Đã xóa phòng ban có id = " + id +" thành công</h1>");
        }else {
            out.println("<h1>Thao tác xóa thất bại</h1>");
        }
        out.println("</body></html>");
    }
}
