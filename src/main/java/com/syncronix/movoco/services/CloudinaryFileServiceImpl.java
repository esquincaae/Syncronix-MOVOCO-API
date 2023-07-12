package com.syncronix.movoco.services;

import com.cloudinary.Cloudinary;
import com.syncronix.movoco.Utils.FileUtils;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.services.interfaces.IFileService;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryFileServiceImpl implements IFileService {

    @Value("${CLOUDINARY_NAME}")
    private String cloudName;

    @Value("${CLOUDINARY_API_KEY}")
    private String apiKey;

    @Value("${CLOUDINARY_API_SECRET}")
    private String apiSecret;

    private final FileUtils fileUtils;


    private final Cloudinary cloudinary = new Cloudinary();


    private final Map<String, String> cloudinaryConfig = new HashMap<>();

    public CloudinaryFileServiceImpl(FileUtils fileUtils) {
        this.fileUtils = fileUtils;
    }


    @Override
    public BaseResponse upload(MultipartFile multipartFile) {
        String fileUrl = "";

        try {

            File file = fileUtils.convertMultipartFileToFile(multipartFile);

            String fileName = fileUtils.generateFileName(multipartFile);

            fileUrl = uploadFileToCloudinary(fileName, file);

        }catch (Exception e){
            e.printStackTrace();
        }

        Map<String, String> message = new HashMap<>();
        message.put("url", fileUrl);

        return BaseResponse.builder()
                .data(message)
                .message("Image correctly upload")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();

    }

    @Override
    public void delete(String imageUrl) {

        String fileName = getFileNameFromUrl(imageUrl);

        String publicId = "IntelliFish-Images" + fileUtils.removeExtensionFromFileName(fileName); //PREGUNTAR QUE RUTA VA AHI

        try {
            Map response = cloudinary.uploader().destroy(publicId, cloudinaryConfig);
        }catch (IOException e){
            throw new RuntimeException();
        }

    }


    private String getFileNameFromUrl(String filename){
        return filename.substring(filename.lastIndexOf("/")+1);
    }

    private String uploadFileToCloudinary(String fileName, File file) throws IOException {
        cloudinaryConfig.put("public_id", fileName);
        Map response = cloudinary.uploader().upload(file, cloudinaryConfig);

        return (String) response.get("url");
    }

    @PostConstruct
    private void initializeCloudinary(){
        cloudinaryConfig.put("cloud_name", cloudName);
        cloudinaryConfig.put("api_key", apiKey);
        cloudinaryConfig.put("api_secret", apiSecret);
        cloudinaryConfig.put("folder", "IntelliFish-Images"); //IGUAL PREGUNTAR QUE RUTA VA
    }
}
