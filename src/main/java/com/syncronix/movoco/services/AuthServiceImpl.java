package com.syncronix.movoco.services;

import com.syncronix.movoco.controllers.dtos.requests.AuthenticationRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.security.JWTUtils;
import com.syncronix.movoco.services.interfaces.IAuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AuthenticationManager authenticationManager;

    @Value("${codehive.app.jwtSecret}")
    private String jwtSecret;

    @Override
    public BaseResponse authenticate(AuthenticationRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String email = userDetails.getUsername();

        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", userDetails.getUser().getId());

        String token = JWTUtils.generateToken(jwtSecret, email, payload);

        Map<String,String> data = new HashMap<>();
        data.put("accessToken: ", token);

        return BaseResponse.builder()
                .data(data)
                .message("Success")
                .status(HttpStatus.CREATED)
                .success(Boolean.TRUE)
                .build();
    }
}
