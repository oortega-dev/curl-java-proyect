package com.airtek.CURL.Interface;

import com.airtek.CURL.Entity.Employee;
import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Model.Request.CreateEmployeeRequest;
import com.airtek.CURL.Model.Response.BaseResponse;
import com.airtek.CURL.Model.Response.CreateEmployeeResponse;
import com.airtek.CURL.Model.Response.GetEmployeeResponse;
import com.airtek.CURL.Model.Response.GetRequestResponse;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    CreateEmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) throws ControllerException;

    BaseResponse removeEmployee(String documentId) throws ControllerException;

    BaseResponse updateEmployee(CreateEmployeeRequest createEmployeeRequest) throws ControllerException;

    GetEmployeeResponse getEmployee(String documentId) throws ControllerException;

    List<GetEmployeeResponse> getEmployeesList() throws ControllerException;

    BaseResponse updateRecord(CreateEmployeeRequest createEmployeeRequest, Optional<Employee> optionalEmployee);

    List<GetRequestResponse> getEmployeeRequest(String documentId) throws ControllerException;
}
