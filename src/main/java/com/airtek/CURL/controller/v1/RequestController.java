package com.airtek.CURL.controller.v1;

import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Model.Request.CreateEmployeeRequest;
import com.airtek.CURL.Model.Request.CreateRequestRequest;
import com.airtek.CURL.Model.Response.BaseResponse;
import com.airtek.CURL.Model.Response.CreateRequestResponse;
import com.airtek.CURL.Service.Impl.RequestServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springdoc.webmvc.core.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/curl-ms")
@CrossOrigin
public class RequestController {
    protected final Log logger = LogFactory.getLog(RequestController.class);

    @Autowired
    protected RequestServiceImpl requestService;

    @PostMapping(value = "/create-colection")
    @Operation(summary = "create colection")
    public CreateRequestResponse CreateColection(@RequestBody CreateRequestResponse createRequestResponse) throws ControllerException {
        return null;
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


}
