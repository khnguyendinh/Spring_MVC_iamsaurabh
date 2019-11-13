package org.saurabhsood.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice(basePackages="org.saurabhsood.controllers")
public class GlobalExceptionHandling {
    @ExceptionHandler(IOException.class)
    private ModelAndView processIOException(IOException ex) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("error", ex.getMessage());
        return model;
    }
}