package com.mocovo.mocovo.controllers.dto.requests;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class UserRequest {
    private String email;
    private String password;
    private Long rolId;

}
