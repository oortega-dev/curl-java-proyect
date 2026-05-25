package com.airtek.CURL.Interface;

import com.airtek.CURL.Entity.Employee;
import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Model.Request.EmployeeRequest;
import com.airtek.CURL.Model.Response.BaseResponse;
import com.airtek.CURL.Model.Response.CreateEmployeeResponse;
import com.airtek.CURL.Model.Response.GetEmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    CreateEmployeeResponse createEmployee(EmployeeRequest employeeRequest) throws ControllerException;

    BaseResponse removeEmployee(String documentId) throws ControllerException;

    BaseResponse updateEmployee(EmployeeRequest employeeRequest) throws ControllerException;

    GetEmployeeResponse getEmployee(String documentId) throws ControllerException;

    List<GetEmployeeResponse> getEmployeesList() throws ControllerException;

    BaseResponse updateRecord(EmployeeRequest employeeRequest, Optional<Employee> optionalEmployee);

}
