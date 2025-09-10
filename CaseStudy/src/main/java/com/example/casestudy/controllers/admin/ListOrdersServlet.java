package com.example.casestudy.controllers.admin;

import com.example.casestudy.models.Orders;
import com.example.casestudy.models.User;
import com.example.casestudy.services.OrdersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class ListOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrdersService ordersService = new OrdersService();
        List<Orders> orders = ordersService.getAllOrders();
        req.setAttribute("orders", orders);
//        User user = (User) req.getSession().getAttribute("user");
//        if ("admin".equals(user.getRole())) {
//            req.getRequestDispatcher("/list-orders.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("/user.jsp").forward(req, resp);
//        }
        req.getRequestDispatcher("/list-orders.jsp").forward(req, resp);
//        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}
