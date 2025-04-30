package org.example.cada.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return "redirect:/";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFound(NoHandlerFoundException ex) {
        return "redirect:/";
    }
}
