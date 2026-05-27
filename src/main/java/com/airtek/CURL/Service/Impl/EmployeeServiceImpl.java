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
import com.airtek.CURL.Model.Response.GetRequestResponse;
import com.airtek.CURL.Repository.EmployeeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.airtek.CURL.Exception.ErrorResponses.*;

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
            Employee employee = new Employee(createEmployeeRequest);
            repo.save(employee);
            return new CreateEmployeeResponse(createEmployeeRequest);
        }
    }

    @Override
    public BaseResponse removeEmployee(String documentId) throws ControllerException {
        logger.info("remove employee service");
        Optional<Employee> optionalEmployee = repo.findOneByDocumentId(documentId);
        if (optionalEmployee.isPresent()) {
            repo.delete(optionalEmployee.get());
            return new BaseResponse();
        }
        throw new ControllerException(EMPLOYEE_NOT_EXIST, Language.ENGLISH);
    }

    @Override
    public BaseResponse updateEmployee(CreateEmployeeRequest createEmployeeRequest) throws ControllerException {
        logger.info("update employee service");
        Optional<Employee> optionalEmployee = repo.findOneByDocumentId(createEmployeeRequest.getDocumentId());
        if (optionalEmployee.isPresent()) {
            return updateRecord(createEmployeeRequest, optionalEmployee);
        } else
            throw new ControllerException(EMPLOYEE_NOT_EXIST, Language.ENGLISH);
    }

    @Override
    public GetEmployeeResponse getEmployee(String documentId) throws ControllerException {
        logger.info("get employee service");
        Optional<Employee> optionalEmployee = repo.findOneByDocumentId(documentId);
        if (optionalEmployee.isPresent()) {
            return new GetEmployeeResponse(optionalEmployee.get());
        } else {
            throw new ControllerException(EMPLOYEE_NOT_EXIST, Language.ENGLISH);
        }
    }

    @Override
    public List<GetEmployeeResponse> getEmployeesList() throws ControllerException {
        logger.info("get employee service");
        List<GetEmployeeResponse> listEmployee = repo.findAll()
                .stream()
                .map(GetEmployeeResponse::new)
                .toList();
        return listEmployee;
    }

    @Override
    public List<GetRequestResponse> getEmployeeRequest(String documentId) throws ControllerException {
        logger.info("get employee requests service");
        Optional<Employee> employee = repo.findOneByDocumentId(documentId);
        if (employee.isPresent()) {
            List<GetRequestResponse> requests = employee.get().getRequests()
                    .stream()
                    .map(GetRequestResponse::new)
                    .toList();
            return requests;
        } else {
            throw new ControllerException(EMPLOYEE_NOT_EXIST, Language.ENGLISH);
        }
    }

    @Override
    public BaseResponse updateRecord(CreateEmployeeRequest createEmployeeRequest, Optional<Employee> optionalEmployee) {
        Employee employee = optionalEmployee.get();
        if (null != createEmployeeRequest.getName())
            employee.setName(createEmployeeRequest.getName());
        if (null != createEmployeeRequest.getLastName())
            employee.setLastName(createEmployeeRequest.getLastName());
        if (null != createEmployeeRequest.getGender())
            employee.setGender(createEmployeeRequest.getGender());
        if (null != createEmployeeRequest.getBirthDate())
            employee.setBirthDate(createEmployeeRequest.getBirthDate());
        if (null != createEmployeeRequest.getIncome())
            employee.setIncome(createEmployeeRequest.getIncome());
        if (null != createEmployeeRequest.getEmployeeType())
            employee.setEmployeeType(createEmployeeRequest.getEmployeeType());
        repo.save(employee);
        return new BaseResponse();
    }
}
