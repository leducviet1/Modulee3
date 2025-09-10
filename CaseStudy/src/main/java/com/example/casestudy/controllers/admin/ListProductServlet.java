package com.example.casestudy.controllers.admin;

import com.example.casestudy.models.Orders;
import com.example.casestudy.services.OrdersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/list-product")
public class ListProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrdersService ordersService = new OrdersService();
        List<Orders> products = ordersService.getAllOrders();
        req.setAttribute("products", products);

        req.getRequestDispatcher("/user.jsp").forward(req, resp);
    }
}
