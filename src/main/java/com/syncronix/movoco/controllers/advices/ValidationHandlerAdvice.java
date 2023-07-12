package com.syncronix.movoco.controllers.advices;

import com.syncronix.movoco.controllers.dtos.responses.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationHandlerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException exception,
             HttpHeaders headers,
             HttpStatusCode statusCode,
             WebRequest request){
        Map<String, String> errors = new HashMap<>();
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        errorList.forEach((error)-> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        BaseResponse baseResponse = BaseResponse.builder()
                .data(errors)
                .message("Validation failed")
                .success(Boolean.FALSE)
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }
}
