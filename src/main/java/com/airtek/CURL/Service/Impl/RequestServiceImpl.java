package com.airtek.CURL.Service.Impl;

import com.airtek.CURL.Entity.Request;
import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Interface.IRequestService;
import com.airtek.CURL.Model.Request.RequestRequest;
import com.airtek.CURL.Model.Response.BaseResponse;
import com.airtek.CURL.Model.Response.CreateRequestResponse;
import com.airtek.CURL.Model.Response.GetRequestResponse;
import com.airtek.CURL.Repository.RequestRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements IRequestService {

    protected final Log logger = LogFactory.getLog(RequestServiceImpl.class);

    @Autowired
    RequestRepository repo;

    @Override
    public CreateRequestResponse createRequest(RequestRequest request) throws ControllerException {
        logger.info("Create Request service");

        return null;
    }

    @Override
    public BaseResponse removeRequest(Long id) throws ControllerException {
        return null;
    }

    @Override
    public BaseResponse updateRequest(RequestRequest request) throws ControllerException {
        return null;
    }

    @Override
    public GetRequestResponse getRequest(Long id) throws ControllerException {
        return null;
    }

    @Override
    public List<GetRequestResponse> getRequestList() throws ControllerException {
        return List.of();
    }

    @Override
    public BaseResponse updateRecord(RequestRequest requestRequest, Optional<Request> optionalRequest) {
        return null;
    }
}
