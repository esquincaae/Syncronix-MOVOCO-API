package com.mocovo.mocovo.controllers.dto.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CartResponse {
    private Long id;
    private UserResponse userResponse;
    private ProductResponse productResponse;
    private Integer quantity;
    private Double totalPrice;
}
