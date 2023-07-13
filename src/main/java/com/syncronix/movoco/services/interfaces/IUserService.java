package com.syncronix.movoco.services.interfaces;

import com.syncronix.movoco.controllers.dtos.requests.UserRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.entities.User;

public interface IUserService {

    BaseResponse create (UserRequest request);

    BaseResponse get(Long id);
    BaseResponse update(UserRequest request, Long id);

    BaseResponse delete(Long id);

    User findOneAndEnsureExistById(Long id);
}
