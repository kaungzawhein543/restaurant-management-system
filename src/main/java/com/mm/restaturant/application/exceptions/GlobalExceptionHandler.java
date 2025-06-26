/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.restaturant.application.exceptions;

import com.mm.restaturant.application.data_transfer_objects.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletionException;

/**
 * GlobalExceptionHandler Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Map<Class<? extends Exception>, ErrorResponseDto> STATUS_MAP = new HashMap<>();
    private static final ErrorResponseDto ERROR_RESPONSE = new ErrorResponseDto();

    static {
        STATUS_MAP.put(NullPointerException.class, new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred. Please try again later."));
        STATUS_MAP.put(BadCredentialsException.class, new ErrorResponseDto(HttpStatus.FORBIDDEN.value(), "Invalid email or password."));
        STATUS_MAP.put(UsernameNotFoundException.class, new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), "An unexpected error occurred. Please try again later."));
        STATUS_MAP.put(DataIntegrityViolationException.class, new ErrorResponseDto(HttpStatus.NOT_ACCEPTABLE.value(), "Incorrect input."));
        STATUS_MAP.put(IOException.class, new ErrorResponseDto(HttpStatus.NOT_ACCEPTABLE.value(), "Incorrect input."));
        STATUS_MAP.put(InternalAuthenticationServiceException.class, new ErrorResponseDto(HttpStatus.UNAUTHORIZED.value(), null));
        STATUS_MAP.put(HttpRequestMethodNotSupportedException.class, new ErrorResponseDto(HttpStatus.METHOD_NOT_ALLOWED.value(), null));
        STATUS_MAP.put(CompletionException.class, new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), null));
        STATUS_MAP.put(NoResourceFoundException.class, new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), null));
        STATUS_MAP.put(MaxUploadSizeExceededException.class, new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), null));
        STATUS_MAP.put(IllegalArgumentException.class, new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), null));
        //Can add more exception that you want to handle.
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(final Exception ex) {

        log.error("Exception : ", ex);
        final ErrorResponseDto errorResponse = STATUS_MAP.getOrDefault(ex.getClass(), new ErrorResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred. Please try again later."
        ));

        ERROR_RESPONSE.setErrorCode(errorResponse.getErrorCode());
        ERROR_RESPONSE.setMessage(errorResponse.getMessage() == null ?
                ex.getMessage() :
                errorResponse.getMessage());

        final ResponseEntity<ErrorResponseDto> responseDTOResponseEntity = new ResponseEntity<>(ERROR_RESPONSE, HttpStatus.valueOf(ERROR_RESPONSE.getErrorCode()));
        log.info("Error response : {}", responseDTOResponseEntity);
        return responseDTOResponseEntity;
    }
}
