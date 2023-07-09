package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.responses.BaseResponse;

public interface ICategoryService {
    BaseResponse get(Long id);

    BaseResponse list();

    BaseResponse delete(Long id);

    BaseResponse create(CategoryRequest request);

    BaseResponse update(Long id, CategoryRequest request);
}
