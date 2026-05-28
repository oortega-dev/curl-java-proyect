package com.airtek.CURL.controller.v1;

import com.airtek.CURL.Exception.ControllerException;

import com.airtek.CURL.Model.Request.CreateRequestRequest;
import com.airtek.CURL.Model.Response.*;
import com.airtek.CURL.Service.Impl.RequestServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curl-ms")
@CrossOrigin
public class RequestController {
    protected final Log logger = LogFactory.getLog(RequestController.class);

    @Autowired
    protected RequestServiceImpl requestService;

    @PostMapping(value = "/create-request")
    @Operation(summary = "create request")
    public CreateRequestResponse createRequest(@RequestBody CreateRequestRequest createRequestRequest) throws ControllerException {
        return requestService.createRequest(createRequestRequest);
    }

    @PutMapping(value = "/update-request")
    @Operation(summary = "update request")
    public BaseResponse updateRequest(@RequestBody CreateRequestRequest createRequestRequest, @RequestParam String documentId) throws ControllerException {
        return requestService.updateRequest(createRequestRequest, documentId);
    }

    @DeleteMapping(value = "/remove-request")
    @Operation(summary = "remove request")
    public BaseResponse removeRequest(@RequestParam String name) throws ControllerException {
        return requestService.removeRequest(name);
    }

    @GetMapping(value = "/get-request")
    @Operation(summary = "get request")
    public GetRequestResponse getRequest(@RequestParam String name) throws ControllerException {
        return requestService.getRequest(name);
    }

    @GetMapping(value = "/get-request-list")
    @Operation(summary = "get requests list")
    public List<GetRequestResponse> getRequestList() throws ControllerException {
        return requestService.getRequestList();
    }

    @GetMapping(value = "/getReports")
    @Operation(summary = "get every request update")
    public List<GetBackupResponse> getReports(@RequestParam String name) throws ControllerException {
        return requestService.getReports(name);
    }
}
