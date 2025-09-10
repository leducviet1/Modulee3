package com.example.casestudy.controllers.admin;

import com.example.casestudy.models.Categories;
import com.example.casestudy.models.Orders;
import com.example.casestudy.models.User;
import com.example.casestudy.services.CategoryService;
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
        String q= req.getParameter("q");
        String sortBy = req.getParameter("sortBy");
        String categoryId = req.getParameter("categoryId");
        String sortOrder = req.getParameter("sortOrder");

        OrdersService ordersService = new OrdersService();
        List<Orders> orders = ordersService.getAllOrders(q, sortBy,categoryId,sortOrder);

        CategoryService categoryService = new CategoryService();
        List<Categories> categories = categoryService.getAllCategories();

        req.setAttribute("categories", categories);
        req.setAttribute("orders", orders);
        req.setAttribute("categoryId", categoryId);
        req.setAttribute("sortOrder", sortOrder);
        req.getRequestDispatcher("/list-orders.jsp").forward(req, resp);

    }
}
