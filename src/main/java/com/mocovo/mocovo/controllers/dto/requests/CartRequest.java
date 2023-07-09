package com.mocovo.mocovo.controllers.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CartRequest {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
}
