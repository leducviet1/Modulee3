package com.example.casestudy.controllers.admin;

import com.example.casestudy.models.User;
import com.example.casestudy.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete-user")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserService userService = new UserService();
        User user = userService.getUserById(Integer.parseInt(id));

        int row = userService.deleteUser(Integer.parseInt(id));
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Delete Department</title></head><body>");
        if(row>0){
            out.println("<h1>Đã xóa tài khoản : " + user.getUsername() +" thành công</h1>");
        }else {
            out.println("<h1>Thao tác xóa thất bại</h1>");
        }
        out.println("</body></html>");
    }
}
