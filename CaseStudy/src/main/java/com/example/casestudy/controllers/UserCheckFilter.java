package com.example.casestudy.controllers;

import com.example.casestudy.models.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class UserCheckFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if(!req.getRequestURI().contains("login")&&!req.getRequestURI().contains("register") && user == null) {
            req.getRequestDispatcher("/login.jsp").forward(req, res);
            return;
        }
        if ((req.getRequestURI().startsWith(req.getContextPath() + "/admin")
                || req.getRequestURI().endsWith("/orders")
                || req.getRequestURI().endsWith("/categories"))
                && !"admin".equals(user.getRole())) {
            // User thường không được phép
            res.sendRedirect(req.getContextPath() + "/user.jsp"); // Hoặc trang home user
            return;
        }
        chain.doFilter(req, res); //continue request
        //Nếu chưa thì forward ssang login
        // Neeuss đã có rồi thì chạy tiếp

    }
}
