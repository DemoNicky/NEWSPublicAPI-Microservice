package com.dobudobu.article_management_service.Exception.ExceptionHandler;

import com.dobudobu.article_management_service.Dto.Response.ResponseHandling;
import com.dobudobu.article_management_service.Exception.ServiceCustomException.CustomExceptionAlreadyExists;
import com.dobudobu.article_management_service.Exception.ServiceCustomException.CustomExceptionUploadFileError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {CustomExceptionAlreadyExists.class})
    public ResponseEntity<Object> customExceptionAlreadyExists(CustomExceptionAlreadyExists customExceptionAlreadyExists){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ResponseHandling responseHandling = new ResponseHandling();
        responseHandling.setStatus("error");
        responseHandling.setMessage(customExceptionAlreadyExists.getMessage());
        responseHandling.setHttpStatus(httpStatus);
        responseHandling.setErrors(true);
        return new ResponseEntity<>(responseHandling, httpStatus);
    }

    @ExceptionHandler(value = {CustomExceptionUploadFileError.class})
    public ResponseEntity<Object> customExceptionUploadFileError(CustomExceptionUploadFileError customExceptionUploadFileError){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ResponseHandling responseHandling = new ResponseHandling();
        responseHandling.setStatus("error");
        responseHandling.setMessage(customExceptionUploadFileError.getMessage());
        responseHandling.setHttpStatus(httpStatus);
        responseHandling.setErrors(true);
        return new ResponseEntity<>(responseHandling, httpStatus);
    }
}
