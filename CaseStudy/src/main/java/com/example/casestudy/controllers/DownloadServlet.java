package com.example.casestudy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");

        if (fileName == null || fileName.equals("")) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println("Thieu filename");
            return;
        }
        String UPLOAD_DIR = UploadFileService.getUploadDir();
        File file = new File(UPLOAD_DIR + "/" + fileName);
        if (!file.exists()) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println("File not found ");
            return;
        }
        //xác định mime type cho trình duyệt
        String mimeType = getServletContext().getMimeType(file.getAbsolutePath());
        resp.setContentType(mimeType); //loại file gì?
        resp.setContentLength((int) file.length()); //size

        //Phản hồi về qua Output Stream
        try (InputStream inputStream = new FileInputStream(file)) {
            OutputStream outputStream = resp.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);

            }
        }
    }
}
