package com.airtek.CURL.Service.Impl;

import com.airtek.CURL.Entity.Employee;
import com.airtek.CURL.Entity.Request;
import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Interface.IEmployeeService;
import com.airtek.CURL.Model.Enums.EmployeeType;
import com.airtek.CURL.Model.Enums.Language;
import com.airtek.CURL.Model.Request.EmployeeRequest;
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

import static com.airtek.CURL.Exception.ErrorResponses.*;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeRepository repo;

    protected final Log logger = LogFactory.getLog(EmployeeServiceImpl.class);

    @Override
    public CreateEmployeeResponse createEmployee(EmployeeRequest employeeRequest) throws ControllerException {
        logger.info("create employee service");
        Optional<Employee> optionalEmployee = repo.findOneByDocumentId(employeeRequest.getDocumentId());
        if (optionalEmployee.isPresent())
            throw new ControllerException(EMPLOYEE_ALREADY_EXIST, Language.ENGLISH);
        else {
            EmployeeType defaultType =  EmployeeType.USER;
            List<Request> requests = new ArrayList<>();
            Employee employee = new Employee(employeeRequest, requests);
            repo.save(employee);
            return new CreateEmployeeResponse(employeeRequest);
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
    public BaseResponse updateEmployee(EmployeeRequest employeeRequest) throws ControllerException {
        logger.info("update employee service");
        Optional<Employee> optionalEmployee = repo.findOneByDocumentId(employeeRequest.getDocumentId());
        if (optionalEmployee.isPresent()) {
            return updateRecord(employeeRequest, optionalEmployee);
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
    public BaseResponse updateRecord(EmployeeRequest employeeRequest, Optional<Employee> optionalEmployee) {
        Employee employee = optionalEmployee.get();
        if (null != employeeRequest.getName())
            employee.setName(employeeRequest.getName());
        if (null != employeeRequest.getLastName())
            employee.setLastName(employeeRequest.getLastName());
        if (null != employeeRequest.getGender())
            employee.setGender(employeeRequest.getGender());
        if (null != employeeRequest.getBirthDate())
            employee.setBirthDate(employeeRequest.getBirthDate());
        if (null != employeeRequest.getIncome())
            employee.setIncome(employeeRequest.getIncome());
        if (null != employeeRequest.getEmployeeType())
            employee.setEmployeeType(employeeRequest.getEmployeeType());
        repo.save(employee);
        return new BaseResponse();
    }
}
