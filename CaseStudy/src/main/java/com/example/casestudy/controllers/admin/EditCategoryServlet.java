package com.example.casestudy.controllers.admin;

import com.example.casestudy.models.Categories;
import com.example.casestudy.services.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit-category")
public class EditCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        CategoryService categoryService = new CategoryService();
        Categories category = categoryService.getCategoryById(Integer.parseInt(id));

        req.setAttribute("category",category);
        req.getRequestDispatcher("form-category.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("nameCategory");

        String description = req.getParameter("descriptionCategory");
        Categories category = new Categories(Integer.parseInt(id),name,description);
        CategoryService categoryService = new CategoryService();
        categoryService.updateCategory(category);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Đã cập nhật dữ liệu hành công !");
    }
}
