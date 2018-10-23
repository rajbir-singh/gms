package com.gms.utils;

import com.gms.error.ApiValidationError;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtils {

    public static List<ApiValidationError> fromBindingErrors(Errors errors) {
        List<ApiValidationError> validErrors = new ArrayList<ApiValidationError>();
        ApiValidationError apiValidationError = null;
        for (ObjectError objectError : errors.getAllErrors()) {
            apiValidationError = ApiValidationError.Builder.apiValidationError()
                    .withObject(objectError.getObjectName())
                    .withField(objectError.getObjectName())
                    .withRejectedValue(objectError.getCode())
                    .withMessage(objectError.getDefaultMessage())
                    .build();
            validErrors.add(apiValidationError);
        }
        return validErrors;
    }
}