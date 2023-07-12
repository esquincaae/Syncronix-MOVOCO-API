package com.syncronix.movoco.controllers;

import com.syncronix.movoco.controllers.dtos.requests.AuthenticationRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.services.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private IAuthService service;

    @PostMapping("token")
    public ResponseEntity<BaseResponse> authentication (@RequestBody @Valid AuthenticationRequest request){
        return service.authenticate(request).apply();
    }

}
