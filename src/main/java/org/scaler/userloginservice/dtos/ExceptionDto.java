package org.scaler.userloginservice.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionDto {
    private String message;
    private String status;
}
