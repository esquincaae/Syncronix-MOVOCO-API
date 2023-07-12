package com.syncronix.movoco.Utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Component
public class FileUtils {

    public File convertMultipartFileToFile(MultipartFile multipartFile)throws IOException{

        File convFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        FileOutputStream fileOutputStream = new FileOutputStream(convFile);

        fileOutputStream.write(multipartFile.getBytes());

        fileOutputStream.close();

        return convFile;

    }

    public String generateFileName(MultipartFile multipartFile){

        Date date = new Date();

        String fileName = (date + "-" + multipartFile.getOriginalFilename()).replace(" ","_");

        return removeExtensionFromFileName(fileName);

    }

    public String removeExtensionFromFileName(String fileName){
        if (fileName.indexOf(".") > 0)
            return fileName.substring(0, fileName.lastIndexOf("."));
        return fileName;
    }
}
