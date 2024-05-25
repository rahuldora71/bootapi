package com.boot.api.bootapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.api.bootapi.helper.FileUploadHelper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        try {
            if (file.isEmpty()) {
            // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");

            // return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());

            
        }

        if (!file.getContentType().equals("image/jpeg")&&!file.getContentType().equals("image/png")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only .jpeg content are allowed");

        }
 
        //file upload code
        boolean f = fileUploadHelper.uploadFile(file);
        if (f) {
            // return ResponseEntity.ok("File is succesfully Uploaded");
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());

        }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        // now file uploading 

         
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went wronge Try Again");
    }
}
