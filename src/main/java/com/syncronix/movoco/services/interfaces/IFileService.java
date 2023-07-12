package com.syncronix.movoco.services.interfaces;

import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    BaseResponse upload(MultipartFile multipartFile);

    void delete(String imageUrl);


}
