package com.felixDev.movieFliex.Config;

import com.felixDev.movieFliex.Eception.UsernameOrPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AplicationController {

    @ExceptionHandler(UsernameOrPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String NotfoundException(UsernameOrPasswordException exception){
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> argumentVAlidExceptions(MethodArgumentNotValidException exception){

        Map<String,String> erros = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            erros.put( ((FieldError) error).getField() , error.getDefaultMessage());
        });
        return erros;
    }
}
