package com.airtek.CURL.Exception;

import com.airtek.CURL.Model.Enums.Language;
import com.airtek.CURL.Util.AirtekTokenResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {


    private Integer code;

    private HttpStatus status;
    private String message;
    private List<String> messages;
    private Language language;

    private String statusCode;
    private Object additionalStatusCode;
    private String statusMessage;
    private String additionalStatusMessage;
    private LinkedHashMap contextResponse;

    public ErrorResponse() {
    }

    public ErrorResponse(HttpStatus status, Integer code, String... messages) {
        this.setMessages(Arrays.asList(messages));
        this.setStatus(status);
        this.setCode(code);
    }

    public ErrorResponse(HttpStatus status, Integer code, String message) {
        this.setStatus(status);
        this.setCode(code);
        this.setMessage(message);
    }

    public ErrorResponse(HttpStatus status, Integer code, List<String> messages, String additionalMessage) {
        this.messages = Collections.singletonList(messages.get(0));
        this.setStatus(status);
        this.setCode(code);
        this.additionalStatusMessage = additionalMessage;
    }

    public ErrorResponse(HttpStatus status, AirtekTokenResponse airtekTokenResponse, Integer code, String... messages) {
        this(status, code, messages);
        this.setStatusCode(airtekTokenResponse.getStatusCode());
        this.setAdditionalStatusCode(airtekTokenResponse.getAdditionalStatusCode());
        this.setStatusMessage(airtekTokenResponse.getStatusMessage());
        this.setAdditionalStatusMessage(airtekTokenResponse.getAdditionalStatusMessage());
    }

    public ErrorResponse(HttpStatus status, AirtekTokenResponse airtekTokenResponse, Integer code, Boolean tyk, String... messages) {
        this(status, code, messages);
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("statusCode", airtekTokenResponse.getContextResponse().get("code"));
        linkedHashMap.put("additionalStatusCode", Integer.valueOf(airtekTokenResponse.getAdditionalStatusCode().toString()));
        linkedHashMap.put("statusMessage", airtekTokenResponse.getStatusMessage());
        linkedHashMap.put("additionalStatusMessage", airtekTokenResponse.getAdditionalStatusMessage());
        this.setContextResponse(linkedHashMap);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @JsonIgnore
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Object getAdditionalStatusCode() {
        return additionalStatusCode;
    }

    public void setAdditionalStatusCode(Object additionalStatusCode) {
        this.additionalStatusCode = additionalStatusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getAdditionalStatusMessage() {
        return additionalStatusMessage;
    }

    public void setAdditionalStatusMessage(String additionalStatusMessage) {
        this.additionalStatusMessage = additionalStatusMessage;
    }

    public LinkedHashMap getContextResponse() {
        return contextResponse;
    }

    public void setContextResponse(LinkedHashMap contextResponse) {
        this.contextResponse = contextResponse;
    }
}
