package com.syncronix.movoco.services.interfaces;

import com.syncronix.movoco.controllers.dtos.requests.CreateUserRequest;
import com.syncronix.movoco.controllers.dtos.requests.UpdateUserRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.entities.User;

public interface IUserService {

    BaseResponse create (CreateUserRequest request);

    BaseResponse get(Long id);
    BaseResponse update(UpdateUserRequest request, Long id);

    BaseResponse delete(Long id);

    User findOneAndEnsureExistById(Long id);
}
