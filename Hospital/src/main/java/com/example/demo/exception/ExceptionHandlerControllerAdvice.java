package com.example.demo.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.Specialist;


@Controller
@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {
public ExceptionHandlerControllerAdvice() {
		
	}

	
@ExceptionHandler(SpecialistException.class)
public final ResponseEntity<Object> handleUserNotFoundException(SpecialistException ex, WebRequest request) {
    List<String> specialist = new ArrayList<>();
    specialist.add(ex.getLocalizedMessage());
    ExceptionResponse error = new ExceptionResponse("Specialist Not Found", specialist);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}


	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> specialist = new ArrayList<>();
        specialist.add(ex.getLocalizedMessage());
        ExceptionResponse error = new ExceptionResponse("Specialist Not Found", specialist);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> specialist = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
        	specialist.add(error.getDefaultMessage());
        }
        ExceptionResponse error = new ExceptionResponse("Validation Failed", specialist);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
