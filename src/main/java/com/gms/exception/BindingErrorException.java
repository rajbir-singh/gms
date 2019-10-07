package com.gms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BindingErrorException extends BindException {

    public BindingErrorException(BindingResult bindingResult) {
        super(bindingResult);
    }

}
