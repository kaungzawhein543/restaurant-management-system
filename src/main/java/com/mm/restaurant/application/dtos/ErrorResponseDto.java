package com.mm.restaurant.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ErrorResponseDto {
    private int errorCode;
    private String message;
}
