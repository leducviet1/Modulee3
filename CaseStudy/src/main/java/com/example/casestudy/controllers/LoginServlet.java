package com.example.casestudy.controllers;

import com.example.casestudy.models.User;
import com.example.casestudy.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserService();
        User user = userService.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            if ("admin".equals(user.getRole())) {
                resp.sendRedirect("./orders");
            } else {
                resp.sendRedirect("./list-product"); // user thường redirect sang trang khác
            }
        }else {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().print("Sai");
        }
    }
}
