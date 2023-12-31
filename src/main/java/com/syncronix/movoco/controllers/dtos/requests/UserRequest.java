package com.syncronix.movoco.controllers.dtos.requests;

import lombok.Getter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class UserRequest {
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String lastname;
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String password;
}
