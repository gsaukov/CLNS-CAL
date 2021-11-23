package org.clnscal.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import javax.naming.AuthenticationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorController {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorController.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String handleNotFound(Exception e) {
        LOG.warn("Resource not found ", e.getMessage());
        return "Not found " + e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public String handleNotAuthorized() {
        LOG.warn("Not authorized");
        return "Not authorized";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public String handleValidationExceptions(
            MissingServletRequestParameterException e) {
        LOG.warn("Resource not found ", e.getMessage());
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({WebClientResponseException.class})
    public String handleWebClientException(
            WebClientResponseException e) {
        LOG.warn("Downstream failure ", e);
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleInternalError(Exception e) {
        LOG.error("Something went wrong", e);
        return "Something went wrong";
    }

}
