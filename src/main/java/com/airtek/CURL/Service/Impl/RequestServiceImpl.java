package com.airtek.CURL.Service.Impl;

import com.airtek.CURL.Entity.Backup;
import com.airtek.CURL.Entity.Employee;
import com.airtek.CURL.Entity.Request;
import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Interface.IRequestService;
import com.airtek.CURL.Model.Enums.Language;
import com.airtek.CURL.Model.Request.CreateBackupRequest;
import com.airtek.CURL.Model.Request.CreateRequestRequest;
import com.airtek.CURL.Model.Response.*;
import com.airtek.CURL.Repository.BackupRepository;
import com.airtek.CURL.Repository.EmployeeRepository;
import com.airtek.CURL.Repository.RequestRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.airtek.CURL.Exception.ErrorResponses.REQUEST_ALREADY_EXIST;
import static com.airtek.CURL.Exception.ErrorResponses.REQUEST_NOT_EXIST;

@Service
public class RequestServiceImpl implements IRequestService {

    protected final Log logger = LogFactory.getLog(RequestServiceImpl.class);

    @Autowired
    protected RequestRepository reqRepo;

    @Autowired
    protected EmployeeRepository empRepo;

    @Autowired
    protected BackupRepository backRepo;

    @Override
    public CreateRequestResponse createRequest(CreateRequestRequest createRequestRequest) throws ControllerException {
        logger.info("Create Request service");
        Optional<Employee> employee = empRepo.findOneByDocumentId(createRequestRequest.getEmployeeDocumentId());
        if (reqRepo.findOneByName(createRequestRequest.getName())!=null) {
            Request request = new Request(createRequestRequest, employee.get());
            empRepo.save(employee.get());
            reqRepo.save(request);
            return new CreateRequestResponse(createRequestRequest);
        }
        else{
            throw new ControllerException(REQUEST_ALREADY_EXIST, Language.ENGLISH);
        }
    }

    @Override
    public BaseResponse removeRequest(String name) throws ControllerException {
        logger.info("Remove Request service");
        Request request = reqRepo.findOneByName(name);
        reqRepo.delete(request);
        List<Backup> backups = backRepo.findAll();
        backups.stream()
                .filter(backup -> backup.getOriginalRequest().getName().equals(name))
                .forEach(backup -> {backRepo.delete(backup);});
        return new BaseResponse();
    }

    @Override
    public BaseResponse updateRequest(CreateRequestRequest createRequestRequest, String modifierDocumentId) throws ControllerException {
        logger.info("update employee service");
        if (reqRepo.findOneByName(createRequestRequest.getName())!=null) {
            Request request = reqRepo.findOneByName(createRequestRequest.getName());
            return updateRecord(createRequestRequest, request, modifierDocumentId);
        }
        else{
            throw new ControllerException(REQUEST_NOT_EXIST, Language.ENGLISH);
        }

    }

    @Override
    public GetRequestResponse getRequest(String name) {
        Request request = reqRepo.findOneByName(name);
        if (request!=null){
            return new GetRequestResponse(request);
        } else {
            throw new ControllerException(REQUEST_NOT_EXIST, Language.ENGLISH);
        }
    }

    @Override
    public List<GetRequestResponse> getRequestList() throws ControllerException {
        List<GetRequestResponse> requestList = reqRepo.findAll().stream()
                .map(GetRequestResponse::new)
                .toList();
        return requestList;
    }

    @Override
    public BaseResponse updateRecord(CreateRequestRequest createRequestRequest, Request request, String modifiedDocumentId) {
        CreateBackupRequest backupRequest = new CreateBackupRequest();
        if (null != createRequestRequest.getUrl()){
            backupRequest.setUrlChanged(createRequestRequest.getUrl());
            request.setUrl(createRequestRequest.getUrl());
        }
        if (null != createRequestRequest.getBody()){
            backupRequest.setBodyChanged(createRequestRequest.getBody());
            request.setBody(createRequestRequest.getBody());
        }
        if (null != createRequestRequest.getType()){
            backupRequest.setTypeChanged(createRequestRequest.getType());
            request.setType(createRequestRequest.getType());
        }
        Optional<Employee> employeeChange = empRepo.findOneByDocumentId(createRequestRequest.getEmployeeDocumentId());
        Backup backup = new Backup(backupRequest, request, employeeChange.get());
        backRepo.save(backup);
        reqRepo.save(request);
        return new BaseResponse();
    }

    public List<GetBackupResponse> getReports(String name){
        logger.info("get requests users service");
        Request request = reqRepo.findOneByName(name);
        if (request!=null){
            List<GetBackupResponse> reports = request.getReports()
                    .stream()
                    .map(GetBackupResponse::new)
                    .toList();
            return reports;
        }
        else throw new ControllerException(REQUEST_NOT_EXIST, Language.ENGLISH);
    }
}