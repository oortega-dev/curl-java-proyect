package com.airtek.CURL.Service.Impl;

import com.airtek.CURL.Entity.Employee;
import com.airtek.CURL.Entity.Request;
import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Interface.IEmployeeService;
import com.airtek.CURL.Model.Enums.EmployeeType;
import com.airtek.CURL.Model.Enums.Language;
import com.airtek.CURL.Model.Request.CreateEmployeeRequest;
import com.airtek.CURL.Model.Response.BaseResponse;
import com.airtek.CURL.Model.Response.CreateEmployeeResponse;
import com.airtek.CURL.Model.Response.GetEmployeeResponse;
import com.airtek.CURL.Repository.EmployeeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.airtek.CURL.Exception.ErrorResponses.EMPLOYEE_ALREADY_EXIST;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeRepository repo;

    protected final Log logger = LogFactory.getLog(EmployeeServiceImpl.class);

    @Override
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) throws ControllerException {
        logger.info("create employee service");
        Optional<Employee> optionalEmployee = repo.findOneByDocumentId(createEmployeeRequest.getDocumentId());
        if (optionalEmployee.isPresent())
            throw new ControllerException(EMPLOYEE_ALREADY_EXIST, Language.ENGLISH);
        else {
            EmployeeType defaultType =  EmployeeType.USER;
            List<Request> requests = new ArrayList<>();
            Employee employee = new Employee(createEmployeeRequest, defaultType, requests);
            repo.save(employee);
            return new CreateEmployeeResponse(createEmployeeRequest);
        }
    }

    @Override
    public BaseResponse removeEmployee(String documentId) throws ControllerException {
        return null;
    }

    @Override
    public BaseResponse updateEmployee(CreateEmployeeRequest employeeRequest) throws ControllerException {
        return null;
    }

    @Override
    public GetEmployeeResponse getEmployee(String documentId) throws ControllerException {
        return null;
    }

    @Override
    public List<GetEmployeeResponse> getEmployeesList() throws ControllerException {
        return List.of();
    }
}
