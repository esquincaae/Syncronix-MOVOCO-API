package com.mocovo.mocovo.services;

import com.mocovo.mocovo.config.security.UserDetailsImpl;
import com.mocovo.mocovo.controllers.dto.requests.AuthenticationRequest;
import com.mocovo.mocovo.controllers.dto.responses.BaseResponse;
import com.mocovo.mocovo.services.interfaces.IAuthService;
import com.mocovo.mocovo.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public BaseResponse authenticate(AuthenticationRequest request) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
                );

        Map<String, Object> payload = new HashMap<>();

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String email = userDetails.getUsername();


        payload.put("userId", userDetails.getUser().getId());

        String token = jwtUtils.generateToken(email, payload);

        Map<String, String> data = new HashMap<>();
        data.put("accessToken", token);

        return BaseResponse.builder()
                .data(data)
                .message("Successful authentication")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
