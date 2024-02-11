package org.scaler.userloginservice.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserDto {
    private String name;
    private String Password;
    private String email;
}
