package com.mocovo.mocovo.services.interfaces;

import com.mocovo.mocovo.controllers.dto.requests.AuthenticationRequest;
import com.mocovo.mocovo.controllers.dto.responses.BaseResponse;

public interface IAuthService {
    BaseResponse authenticate(AuthenticationRequest request);
}
