package com.xyz.spring.controller;

import com.xyz.spring.data.FileDAO;
import com.xyz.spring.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {

    @Autowired
    private FileDAO fileDAO;

    @GetMapping(path = {"/", "/form", "index"}, produces = MediaType.TEXT_HTML_VALUE)
    public String uploadFileForm(Model model) {
        model.addAttribute("files", fileDAO.findAll());
        return "fileUploadForm";
    }

    @PostMapping(path = "/submitForm", produces = {MediaType.TEXT_HTML_VALUE})
    @ResponseBody
    public String handleUploadFile(
        @RequestParam(name = "name") String name,
        @RequestParam(name = "file") MultipartFile multipartFile) {

        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(name);

        try {
            byte[] bytes = multipartFile.getBytes();
            if(bytes.length == 0) return "failed";

            fileEntity.setBody(bytes);
            fileDAO.saveFile(fileEntity);

            return "success<script>setTimeout(() => window.location = '/', 1000)</script>";
        }
        catch(IOException ioe) {
            return "failed";
        }
    }

    @GetMapping(path = "/showFile/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] showFile(@PathVariable("id") String id) {
        if(id.isEmpty()) return new byte[]{};

        return this.fileDAO.findFileEntityById(id).getBody();
    }
}
