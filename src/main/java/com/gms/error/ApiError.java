package com.gms.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class ApiError {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private String debugMessage;

    private List<ApiSubError> subErrors;

    public static interface StatusStep {
        TimestampStep withStatus(HttpStatus status);
    }

    public static interface TimestampStep {
        MessageStep withTimestamp(LocalDateTime timestamp);
    }

    public static interface MessageStep {
        DebugMessageStep withMessage(String message);
    }

    public static interface DebugMessageStep {
        SubErrorsStep withDebugMessage(String debugMessage);
    }

    public static interface SubErrorsStep {
        BuildStep withSubErrors(List<ApiSubError> subErrors);
    }

    public static interface BuildStep {
        ApiError build();
    }

    public static class Builder implements StatusStep, TimestampStep, MessageStep, DebugMessageStep, SubErrorsStep, BuildStep {
        private HttpStatus status;
        private LocalDateTime timestamp;
        private String message;
        private String debugMessage;
        private List<ApiSubError> subErrors;

        private Builder() {
        }

        public static StatusStep apiError() {
            return new Builder();
        }

        @Override
        public TimestampStep withStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        @Override
        public MessageStep withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        @Override
        public DebugMessageStep withMessage(String message) {
            this.message = message;
            return this;
        }

        @Override
        public SubErrorsStep withDebugMessage(String debugMessage) {
            this.debugMessage = debugMessage;
            return this;
        }

        @Override
        public BuildStep withSubErrors(List<ApiSubError> subErrors) {
            this.subErrors = subErrors;
            return this;
        }

        @Override
        public ApiError build() {
            ApiError apiError = new ApiError();
            apiError.setStatus(this.status);
            apiError.setTimestamp(this.timestamp);
            apiError.setMessage(this.message);
            apiError.setDebugMessage(this.debugMessage);
            apiError.setSubErrors(this.subErrors);
            return apiError;
        }
    }

//    private ApiError() {
//        timestamp = LocalDateTime.now();
//    }
//
//    ApiError(HttpStatus status) {
//        this();
//        this.status = status;
//    }
//
//    ApiError(HttpStatus status, Throwable ex) {
//        this();
//        this.status = status;
//        this.message = "Unexpected error";
//        this.debugMessage = ex.getLocalizedMessage();
//    }


}
