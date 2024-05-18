package com.todo.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    final String resourcesPath = "src" + File.separator + "main" + File.separator + "resources" +
            File.separator;
    final String showImagePath = resourcesPath + "static" + File.separator + "images" + File.separator;
    final String singleFileUploadPath = resourcesPath + "uploaded" + File.separator + "single" + File.separator;

    @PostMapping("/single")
    ResponseEntity<String> getSingleFile(@RequestParam("image") MultipartFile file) throws IOException {

        logger.info("File Name: {}", file.getName());
        logger.info("File Content: {}", file.getContentType());
        logger.info("File Orignal Name: {}", file.getOriginalFilename());
        logger.info("File Size: {}", file.getSize());

        File dir = new File(singleFileUploadPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        InputStream inputStream = file.getInputStream();
        byte[] data = new byte[inputStream.available()];
        FileOutputStream fileOutputStream = new FileOutputStream(dir + File.separator + file.getOriginalFilename());

        int bytesRead;
        while ((bytesRead = inputStream.read(data)) != -1) {
            fileOutputStream.write(data, 0, bytesRead);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded");
    }

    @PostMapping("/multiple")
    ResponseEntity<String> getMultipleFile(@RequestParam("files") MultipartFile[] files) {

        Arrays.stream(files).forEach(file->{
            logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            logger.info("File Name: {}", file.getOriginalFilename());
            logger.info("File type: {}",file.getContentType());
            logger.info("File Size: {}",file.getSize());
        });
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return ResponseEntity.ok("Hadling multiple files");
    }

    @GetMapping("show-image")
    ResponseEntity<String> showImage(HttpServletResponse response) throws IOException {

        InputStream is = new FileInputStream(showImagePath + "show.jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(is, response.getOutputStream());
        return ResponseEntity.ok("Done");
    }

}
