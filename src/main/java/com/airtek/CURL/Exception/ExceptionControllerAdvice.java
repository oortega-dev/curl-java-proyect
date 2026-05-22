package com.airtek.CURL.Exception;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({ControllerException.class})
    @ResponseBody
    private ErrorResponse exceptionHandler(ControllerException ce, HttpServletResponse response) {
        getMessage(ce);

        logger.error("Controller Exception detected: " + ce.getErrorResponse().getStatus() + " " + ce.getErrorResponse().getMessage());

        if (null != ce.getMessage())
            logger.error("ce.getMessage(): " + ce.getMessage());

        if (null != ce.getErrorResponse().getMessages().get(0))
            logger.error("ce.getErrorResponse().getMessages().get(0)): " + ce.getErrorResponse().getMessages().get(0));

        if (null != ce.getErrorResponse().getMessage())
            logger.error("ce.getErrorResponse().getMessage(): " + ce.getErrorResponse().getMessage());

        if (null != ce.getErrorResponse().getAdditionalStatusMessage())
            logger.error("ce.getErrorResponse().getAdditionalStatusMessage(): " + ce.getErrorResponse().getAdditionalStatusMessage());

        logger.error("Controller Exception detail", ce);
        response.setStatus(ce.getErrorResponse().getStatus().value());
        return ce.getErrorResponse();
    }

//    @ExceptionHandler({Exception.class})
//    @ResponseBody
//    private ErrorResponse exceptionHandler(Exception ex, HttpServletResponse response, Integer code) {
//        logger.error("Unhandled exception detected", ex);
//        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, code, ex.getMessage());
//    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse exceptionHandler(Exception ex, HttpServletResponse response) {
        logger.error("Unhandled exception detected", ex);
        HttpStatus status;
        if (ex.getMessage().equalsIgnoreCase("Access is denied")) {
            status = HttpStatus.UNAUTHORIZED;
            return new ErrorResponse(status, status.value(), "Access is denied, the user has not privileges to access this endpoint");

        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setStatus(status.value());

            return new ErrorResponse(status, status.value(), ex.getMessage());
        }
    }

    private void getMessage(ControllerException ce) {
        if (null != ce.getErrorResponse().getLanguage()) {
            switch (ce.getErrorResponse().getLanguage()) {
                case ENGLISH:
                    ce.getErrorResponse().setMessage(ce.getErrorResponse().getMessages().get(0));
                    break;
                default:
                    ce.getErrorResponse().setMessage(ce.getErrorResponse().getMessages().get(0));
            }
        } else {
            ce.getErrorResponse().setMessage(ce.getErrorResponse().getMessages().get(0));
        }

    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> handleException(MissingRequestHeaderException ex) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleException(MissingServletRequestParameterException ex) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleJsonErrors(HttpMessageNotReadableException ex) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> validationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        errorResponse.setMessage(fieldErrors.get(0).getField() + ": " + fieldErrors.get(0).getDefaultMessage());
        logger.error("Controller Exception detail", ex);
        logger.error("*********************************************************************");
        logger.error("ERROR: " + Objects.requireNonNull(ex.getFieldError()).getField() + " " + ex.getFieldError().getDefaultMessage());
        logger.error("Object: " + ex.getFieldError().getObjectName());
        logger.error("*********************************************************************");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        logger.error("Controller Exception detail", ex);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
