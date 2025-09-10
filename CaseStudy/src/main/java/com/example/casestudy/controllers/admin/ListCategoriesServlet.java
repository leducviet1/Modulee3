package com.example.casestudy.controllers.admin;

import com.example.casestudy.models.Categories;
import com.example.casestudy.services.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/categories")
public class ListCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService service = new CategoryService();
        List<Categories> categories = service.getAllCategories();

        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/list-categories.jsp").forward(req, resp);
    }
}
