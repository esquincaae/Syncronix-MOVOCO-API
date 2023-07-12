package com.syncronix.movoco.controllers.dtos.requests;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
public class UpdateFishRequest {
    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String spices;

    @NotBlank
    @NotNull
    private String imageUrl ;
}
