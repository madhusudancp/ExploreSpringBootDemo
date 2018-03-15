package com.maddy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.maddy.webtos.ExceptionDto;

@ControllerAdvice
@Component
public class ExceptionResources  extends ResponseEntityExceptionHandler {
 
	
	
	@ExceptionHandler(value = { SpringbootServiceException.class })
    protected ResponseEntity<ExceptionDto> handleConflict(SpringbootServiceException ex, WebRequest request) {
        
        return  new ResponseEntity<ExceptionDto>(ex.getExceptionDto(),HttpStatus.PRECONDITION_FAILED);
    }
    
	
	
	
	@ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<ExceptionDto> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse =ex.getMessage();
        ExceptionDto error =new ExceptionDto();
        error.setErrorCode(5000);
        error.setErrorMessage(bodyOfResponse);
        ex.printStackTrace();
        System.out.println(ex.getMessage());
        return  new ResponseEntity<ExceptionDto>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //http://www.naturalprogrammer.com/spring-framework-rest-api-validation/
 
}