package com.example.casestudy.controllers.admin;

import com.example.casestudy.models.Categories;
import com.example.casestudy.services.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/create-category")
public class CreateCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("form-category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameCategory");
        String  description = req.getParameter("descriptionCategory");
        Categories categories = new Categories(name,description);

        CategoryService categoryService = new CategoryService();
        if (categoryService.existsByName(name)) {
            req.setAttribute("error", "Tên loại đã tồn tại!");
            req.getRequestDispatcher("form-category.jsp").forward(req, resp);
            return;
        }
        categoryService.addCategory(categories);

        resp.sendRedirect("./categories");

    }
}
