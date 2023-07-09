package com.mocovo.mocovo.services.interfaces;

import com.mocovo.mocovo.controllers.dto.requests.CartRequest;
import com.mocovo.mocovo.controllers.dto.responses.BaseResponse;

public interface ICartService {

    BaseResponse list(Long id);

    BaseResponse delete(Long id);

    BaseResponse create(CartRequest request);

    BaseResponse update(Long id, CartRequest request);

}
