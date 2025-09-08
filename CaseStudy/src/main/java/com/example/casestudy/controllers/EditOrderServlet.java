package com.example.casestudy.controllers;

import com.example.casestudy.models.Categories;
import com.example.casestudy.models.Orders;
import com.example.casestudy.services.CategoryService;
import com.example.casestudy.services.OrdersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/edit-order")
@MultipartConfig()
public class EditOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //Lấy dữ liệu cũ
        OrdersService service = new OrdersService();
        Orders order = service.getById(Integer.parseInt(id));
//        Orders orders = service.getAllOrders();
        CategoryService categoryService = new CategoryService();
        List<Categories> categoryList = categoryService.getAllCategories();

        req.setAttribute("order", order);
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("form-order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("nameOrder");



//        BigDecimal price = new BigDecimal(req.getParameter("priceOrder"));
        // Xử lý giá
        String priceStr = req.getParameter("priceOrder");
        BigDecimal price = BigDecimal.ZERO;
        if (priceStr != null && !priceStr.isEmpty()) {
            price = new BigDecimal(priceStr);
        }
        //Xử lý ảnh
        Part imagePart = req.getPart("imageOrder");
        String fileNameImage = imagePart != null? imagePart.getSubmittedFileName(): "";
        String finalImage;
        if(fileNameImage != null && !fileNameImage.isEmpty()) {
            String UPLOAD_DIR = UploadFileService.getUploadDir();
            File upload_Dir = new File(UPLOAD_DIR);
            if (!upload_Dir.exists()) {
                upload_Dir.mkdir();
            }
            imagePart.write(UPLOAD_DIR + "/" +fileNameImage);
            finalImage = fileNameImage;
        }else {
            OrdersService service = new OrdersService();
            Orders order = service.getById(Integer.parseInt(id));
            finalImage = order.getImage();
        }

        String description = req.getParameter("descriptionOrder");
        String category = req.getParameter("categoryOrder");
        String status = req.getParameter("status");
        Orders order = new Orders(Integer.parseInt(id),name,price,finalImage,description,status,Integer.parseInt(category));
        OrdersService service = new OrdersService();
        service.updateOrders(order);


        //Phản hồi thông tin cho người dùng
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Đã cập nhật dữ liệu hành công !");

    }
}
