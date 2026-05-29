package com.airtek.CURL.controller.v1;

import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Interface.IEmployeeService;
import com.airtek.CURL.Model.Request.CreateEmployeeRequest;
import com.airtek.CURL.Model.Response.BaseResponse;
import com.airtek.CURL.Model.Response.CreateEmployeeResponse;
import com.airtek.CURL.Model.Response.GetEmployeeResponse;
import com.airtek.CURL.Model.Response.GetRequestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/curl-ms")
@CrossOrigin
public class EmployeeController {
    protected final Log logger = LogFactory.getLog(EmployeeController.class);

    @Autowired
    protected IEmployeeService employeeService;

    @PostMapping(value = "/create-employee")
    @Operation(summary = "create employee")
    public CreateEmployeeResponse createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) throws ControllerException {
        return employeeService.createEmployee(createEmployeeRequest);
    }

    @PutMapping(value = "/update-employee")
    @Operation(summary = "update Employee")
    public BaseResponse updateEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) throws ControllerException {
        return employeeService.updateEmployee(createEmployeeRequest);
    }

    @DeleteMapping(value = "/remove-employee")
    @Operation(summary = "remove Employee")
    public BaseResponse removeEmployee(@RequestParam String documentId) throws ControllerException {

        return employeeService.removeEmployee(documentId);
    }

    @GetMapping(value = "/get-employee")
    @Operation(summary = "get Employee")
    public GetEmployeeResponse getEmployee(@RequestParam String documentId) throws ControllerException {
        return employeeService.getEmployee(documentId);
    }

    @GetMapping(value = "/get-employees")
    @Operation(summary = "get employees list")
    public List<GetEmployeeResponse> getEmployeesList() throws ControllerException {
        return employeeService.getEmployeesList();
    }

    @GetMapping(value = "/get-employee-request")
    @Operation(summary = "get employee requests")
    public List<GetRequestResponse> getEmployeeRequest(@RequestParam String documentId) throws ControllerException {
        return employeeService.getEmployeeRequest(documentId);
    }
}
