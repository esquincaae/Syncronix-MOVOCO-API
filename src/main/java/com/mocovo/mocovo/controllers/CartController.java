package com.mocovo.mocovo.controllers;

import com.mocovo.mocovo.controllers.dto.requests.CartRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;
import com.example.demo.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> list(@PathVariable Long id) {
        BaseResponse baseResponse = service.list(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    /*@GetMapping("{id}")
    public CartResponse get(@PathVariable Long id) {
        return service.get(id);    }*/

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CartRequest request) {
        BaseResponse baseResponse = service.create(request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody CartRequest request) {
        BaseResponse baseResponse = service.update(id, request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }


    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        BaseResponse baseResponse = service.delete(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

}
