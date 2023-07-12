package com.syncronix.movoco.controllers;

import com.syncronix.movoco.controllers.dtos.requests.CreatePlantRequest;
import com.syncronix.movoco.controllers.dtos.requests.UpdatePlantRequest;
import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import com.syncronix.movoco.services.interfaces.IPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/plant")
public class PlantController {

    @Autowired
    private IPlantService service;

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get (@PathVariable Long id){

        BaseResponse baseResponse = service.get(id);

        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @GetMapping
    public ResponseEntity<BaseResponse> list (@RequestParam(required = false) Long userId){

        BaseResponse baseResponse = service.list(userId);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreatePlantRequest request){

        BaseResponse baseResponse = service.create(request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody @Valid UpdatePlantRequest request){

        BaseResponse baseResponse = service.update(id, request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete (@PathVariable Long id){

        BaseResponse baseResponse = service.delete(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

}
