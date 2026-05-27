package com.airtek.CURL.Interface;

import com.airtek.CURL.Entity.Employee;
import com.airtek.CURL.Entity.Request;
import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Model.Request.CreateRequestRequest;
import com.airtek.CURL.Model.Response.BaseResponse;
import com.airtek.CURL.Model.Response.CreateRequestResponse;
import com.airtek.CURL.Model.Response.GetRequestResponse;

import java.util.List;
import java.util.Optional;

public interface IRequestService {

    CreateRequestResponse createRequest(CreateRequestRequest request) throws ControllerException;

    BaseResponse removeRequest(String name) throws ControllerException;

    BaseResponse updateRequest(CreateRequestRequest request, String modifierDocumentId) throws ControllerException;

    GetRequestResponse getRequest(String name) throws ControllerException;

    List<GetRequestResponse> getRequestList() throws ControllerException;

    BaseResponse updateRecord(CreateRequestRequest createRequestRequest, Request request,String modifierDocumentId);
}
