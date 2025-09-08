package com.example.casestudy.controllers;

import java.io.File;

public class UploadFileService {
    public static String getUploadDir(){
        String UPLOAD_DIR = "I:\\Codegym(Code)\\list-file-casestudy";
        File file = new File(UPLOAD_DIR);
        if (!file.exists()) {
            file.mkdir();
        }
        return UPLOAD_DIR;
    }
}
