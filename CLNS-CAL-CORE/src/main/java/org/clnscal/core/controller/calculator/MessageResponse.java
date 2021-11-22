package org.clnscal.core.controller.calculator;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse {

    private final String message;

    private MessageResponse(Builder builder) {
        this.message = builder.message;
    }


    public static final class Builder {
        private String message;

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public MessageResponse build() {
            return new MessageResponse(this);
        }
    }
}
