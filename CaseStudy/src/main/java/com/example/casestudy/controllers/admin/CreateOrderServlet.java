package com.example.casestudy.controllers.admin;

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
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/create-order")
@MultipartConfig()
public class CreateOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lấy danh sách thể loại để hieern thị
        CategoryService service = new CategoryService();
        List<Categories> categories = service.getAllCategories();
        req.setAttribute("categories", categories);

        req.getRequestDispatcher("form-order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameOrder");
        BigDecimal price = new BigDecimal(req.getParameter("priceOrder"));
        Part filePart = req.getPart("imageOrder");
        String fileName = filePart.getSubmittedFileName(); //lấy tên file

        String UPLOAD_DIR = UploadFileService.getUploadDir();
        File upload_Dir = new File(UPLOAD_DIR);
        if (!upload_Dir.exists()) {
            upload_Dir.mkdir();
        }
//        String uploadedFile = UPLOAD_DIR + "/" + fileName;
        filePart.write(UPLOAD_DIR + "/" +fileName);
//        resp.getWriter().print(uploadedFile);
        String description = req.getParameter("descriptionOrder");
        String category = req.getParameter("categoryOrder");
        String status = req.getParameter("status");
        Orders order;
        if(category == null || category.equals("")){
            order = new Orders(name,price,fileName,description,status);
        }else {
            order = new Orders(name,price,fileName,description,category,status);
        }
        OrdersService service = new OrdersService();
        service.addOrders(order);

        resp.sendRedirect("./orders");
    }
}
