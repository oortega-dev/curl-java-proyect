package com.airtek.CURL.Interface;

import com.airtek.CURL.Entity.Employee;
import com.airtek.CURL.Entity.Request;
import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Model.Request.EmployeeRequest;
import com.airtek.CURL.Model.Request.RequestRequest;
import com.airtek.CURL.Model.Response.BaseResponse;
import com.airtek.CURL.Model.Response.CreateRequestResponse;
import com.airtek.CURL.Model.Response.GetEmployeeResponse;
import com.airtek.CURL.Model.Response.GetRequestResponse;

import java.util.List;
import java.util.Optional;

public interface IRequestService {

    CreateRequestResponse createRequest(RequestRequest request) throws ControllerException;

    BaseResponse removeRequest(Long id) throws ControllerException;

    BaseResponse updateRequest(RequestRequest request) throws ControllerException;

    GetRequestResponse getRequest(Long id) throws ControllerException;

    List<GetRequestResponse> getRequestList() throws ControllerException;

    BaseResponse updateRecord(RequestRequest requestRequest, Optional<Request> optionalRequest);
}
