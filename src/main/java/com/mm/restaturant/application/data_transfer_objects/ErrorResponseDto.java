package com.mm.restaturant.application.data_transfer_objects;

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
