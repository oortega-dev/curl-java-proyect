package com.airtek.CURL.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponses extends ErrorResponse{



    public static final ErrorResponses INTERNAL_SERVER_ERROR = new ErrorResponses(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal error please try again. If the error persist contact us to solve the problem");

    public static final ErrorResponses SESSION_EXPIRED = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "Session expired, please login again");

    public static final ErrorResponses INVALID_SESSION_TOKEN = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "Invalid session token");

    public static final ErrorResponses EMPLOYEE_ALREADY_EXIST = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "Employee already exist");

    public static final ErrorResponses EMPLOYEE_NOT_EXIST = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Employee not exist");


    public static final ErrorResponses CUSTOMER_ID_NOT_SET = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "The customer id must be part of the request");


    public ErrorResponses() {
    }


    public ErrorResponses(HttpStatus httpStatus, Integer code, String... message) {
        super(httpStatus, code, message);
    }

}
