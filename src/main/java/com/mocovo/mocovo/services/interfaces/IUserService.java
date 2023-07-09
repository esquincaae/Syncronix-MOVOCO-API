package com.mocovo.mocovo.services.interfaces;

import com.mocovo.mocovo.controllers.dto.requests.UserRequest;
import com.mocovo.mocovo.controllers.dto.responses.BaseResponse;

public interface IUserService {
    
    BaseResponse get(Long id);

    BaseResponse list();

    BaseResponse delete(Long id);

    BaseResponse create(UserRequest request);

    BaseResponse update(Long id, UserRequest request);
}
