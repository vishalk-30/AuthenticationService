package org.scaler.userloginservice.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseUserDto {
    private String name;
    private Long id;
    private String email;
}
