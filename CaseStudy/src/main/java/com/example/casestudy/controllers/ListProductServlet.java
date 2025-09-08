package com.example.casestudy.controllers;

import com.example.casestudy.models.Orders;
import com.example.casestudy.models.User;
import com.example.casestudy.services.OrdersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListProductServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrdersService ordersService = new OrdersService();
        List<Orders> products = ordersService.getAllOrders();
        req.setAttribute("products", products);
//        User user = (User) req.getSession().getAttribute("user");
//        if ("admin".equals(user.getRole())) {
//            req.getRequestDispatcher("/list-orders.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("/user.jsp").forward(req, resp);
//        }
//        req.getRequestDispatcher("list-orders.jsp").forward(req, resp);
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}
