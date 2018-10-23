package com.gms.error;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public static interface ObjectStep {
        FieldStep withObject(String object);
    }

    public static interface FieldStep {
        RejectedValueStep withField(String field);
    }

    public static interface RejectedValueStep {
        MessageStep withRejectedValue(Object rejectedValue);
    }

    public static interface MessageStep {
        BuildStep withMessage(String message);
    }

    public static interface BuildStep {
        ApiValidationError build();
    }

    public static class Builder implements ObjectStep, FieldStep, RejectedValueStep, MessageStep, BuildStep {
        private String object;
        private String field;
        private Object rejectedValue;
        private String message;

        private Builder() {
        }

        public static ObjectStep apiValidationError() {
            return new Builder();
        }

        @Override
        public FieldStep withObject(String object) {
            this.object = object;
            return this;
        }

        @Override
        public RejectedValueStep withField(String field) {
            this.field = field;
            return this;
        }

        @Override
        public MessageStep withRejectedValue(Object rejectedValue) {
            this.rejectedValue = rejectedValue;
            return this;
        }

        @Override
        public BuildStep withMessage(String message) {
            this.message = message;
            return this;
        }

        @Override
        public ApiValidationError build() {
            return new ApiValidationError(
                    this.object,
                    this.field,
                    this.rejectedValue,
                    this.message
            );
        }
    }

//    ApiValidationError(String object, String message) {
//        this.object = object;
//        this.message = message;
//    }


}

