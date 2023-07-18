package com.syncronix.movoco.controllers;

import com.syncronix.movoco.controllers.dtos.requests.UserRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserController{

    @Autowired
    private IUserService service;

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get (@PathVariable Long id){

        BaseResponse baseResponse = service.get(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid UserRequest request){
        BaseResponse baseResponse = service.create(request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody @Valid UserRequest request){
        BaseResponse baseResponse = service.update(request, id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id){
        BaseResponse baseResponse = service.delete(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }


}