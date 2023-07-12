package com.syncronix.movoco.services.interfaces;

import com.syncronix.movoco.controllers.dtos.requests.AuthenticationRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;

public interface IAuthService {

    BaseResponse authenticate(AuthenticationRequest request);
}
