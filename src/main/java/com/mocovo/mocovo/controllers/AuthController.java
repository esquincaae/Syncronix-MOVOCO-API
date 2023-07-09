package com.mocovo.mocovo.controllers;

import com.mocovo.mocovo.controllers.dto.requests.AuthenticationRequest;
import com.mocovo.mocovo.controllers.dto.responses.BaseResponse;
import com.mocovo.mocovo.services.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private IAuthService service;

    @PostMapping("token")
    public ResponseEntity<BaseResponse> authentication(@RequestBody @Valid AuthenticationRequest request) {
        BaseResponse response = service.authenticate(request);

        return new ResponseEntity<>(response, response.getHttpStatus());
    }


}
