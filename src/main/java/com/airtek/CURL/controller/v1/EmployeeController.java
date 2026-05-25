package com.airtek.CURL.controller.v1;

import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Interface.IEmployeeService;
import com.airtek.CURL.Model.Request.EmployeeRequest;
import com.airtek.CURL.Model.Response.BaseResponse;
import com.airtek.CURL.Model.Response.CreateEmployeeResponse;
import com.airtek.CURL.Model.Response.GetEmployeeResponse;
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

    @PostMapping(value = "/createEmployee")
    @Operation(summary = "create employee")
    public CreateEmployeeResponse createEmployee(@Parameter(description = "User token provided by auth service, sends Bearer, space and token.") @RequestHeader(value = "Authorization") String token,
                                                 @Valid @RequestBody EmployeeRequest employeeRequest) throws ControllerException {

        return employeeService.createEmployee(employeeRequest);
    }

    @PutMapping(value = "/updateEmployee")
    @Operation(summary = "update Employee")
    public BaseResponse updateEmployee(@RequestBody EmployeeRequest employeeRequest) throws ControllerException {
        return employeeService.updateEmployee(employeeRequest);
    }

    @DeleteMapping(value = "/removeEmployee")
    @Operation(summary = "remove Employee")
    public BaseResponse removeEmployee(@RequestParam String documentId) throws ControllerException {

        return employeeService.removeEmployee(documentId);
    }

    @GetMapping(value = "/getEmployee")
    @Operation(summary = "remove Employee")
    public GetEmployeeResponse getEmployee(@RequestParam String documentId) throws ControllerException {
        return employeeService.getEmployee(documentId);
    }

    @GetMapping("/getEmployees")
    public List<GetEmployeeResponse> getEmployeesList() throws ControllerException {
        return employeeService.getEmployeesList();
    }





}
