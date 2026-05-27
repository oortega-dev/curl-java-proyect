package com.airtek.CURL.controller.v1;

import com.airtek.CURL.Exception.ControllerException;
import com.airtek.CURL.Model.Response.CreateRequestResponse;
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
    protected RequestService requestService;

    @PostMapping(value = "/create-colection")
    @Operation(summary = "create colection")
    public CreateRequestResponse CreateColection(@RequestBody CreateRequestResponse createRequestResponse) throws ControllerException {
        return null;
    }

    
}
