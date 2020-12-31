package xyz.demo.thymeleaf.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ResourceController {

    @GetMapping(path = "/img/cat", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getOctet() {
        FileSystemResource fsr = new FileSystemResource("/home/ensign-quaker/Imagens/cat.jpg");

        try {
           return fsr.getInputStream().readAllBytes();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return new byte[]{};
    }
}
