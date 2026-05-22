package com.airtek.CURL.Exception;

import com.airtek.CURL.Model.Enums.Language;
import com.airtek.CURL.Util.AirtekTokenResponse;
import org.springframework.http.ResponseEntity;

public class ControllerException extends RuntimeException {

    private ErrorResponse errorResponse;

    public ControllerException(ErrorResponses internalServerError) {
    }

    public ControllerException(ErrorResponse errorResponse, Language language) {
        this.errorResponse = errorResponse;
        this.errorResponse.setLanguage(language);
    }

    public ControllerException(String message, ErrorResponse errorResponse) {
        super(message);
        this.errorResponse = new ErrorResponse(errorResponse.getStatus(), errorResponse.getCode(), message);
    }

    public ControllerException(String message, ErrorResponse errorResponse, AirtekTokenResponse airtekTokenResponse) {
        super(message);
        this.errorResponse = new ErrorResponse(errorResponse.getStatus(), airtekTokenResponse, errorResponse.getCode(), message);
    }

    public ControllerException(String message, ErrorResponse errorResponse, AirtekTokenResponse airtekTokenResponse, Boolean tyk) {
        super(message);
        this.errorResponse = new ErrorResponse(errorResponse.getStatus(), airtekTokenResponse, errorResponse.getCode(), tyk, message);
    }


    public ControllerException(String message, Throwable cause,
                               ErrorResponse errorResponse) {
        super(message, cause);
        this.errorResponse = errorResponse;
    }

    public ControllerException(ResponseEntity response) {
        response.getStatusCode();
        this.errorResponse = ErrorResponses.INTERNAL_SERVER_ERROR;
    }

    /* Don't know what this method is for, but it's part of the Java API */
    protected ControllerException(String message, Throwable cause,
                                  boolean enableSuppression, boolean writableStackTrace,
                                  ErrorResponse errorResponse) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorResponse = errorResponse;
    }

    public ControllerException(ErrorResponse errorResponse, String additionalMessage) {
        this.errorResponse = new ErrorResponse(errorResponse.getStatus(), errorResponse.getCode(), errorResponse.getMessages(), additionalMessage);
    }

    public ControllerException(Throwable cause, ErrorResponse errorResponse) {
        super(cause);
        this.errorResponse = errorResponse;
    }

    public ControllerException(ErrorResponse errorResponse, String additionalMessage, Language language) {
        this.errorResponse = errorResponse;
        this.errorResponse.setLanguage(language);
        this.errorResponse.setAdditionalStatusMessage(additionalMessage);
    }
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
