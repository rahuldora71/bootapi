package com.boot.api.bootapi.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // public final String UPLOAD_DIR="C:\\Users\\rahul\\Spring boot\\bootapi\\src\\main\\resources\\static\\image";
    public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();

    
    public FileUploadHelper() throws IOException{
    }


    public boolean uploadFile(MultipartFile file)
    {
        boolean f=false;

        try {
            
            //first method

            // InputStream inputStream = file.getInputStream();
            // byte data[]=new byte[inputStream.available()];
            // inputStream.read(data);

            // //write 
            // FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();


            //Second method
            Files.copy(file.getInputStream(),Paths.get( UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);


            f=true;




        } catch (Exception e) {

            e.printStackTrace();
        }


        return f;
    }
}
