package com.airtek.CURL.Model.Response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BaseResponse {
    private HttpStatus statusCode = HttpStatus.OK;
    private Integer code = 200;
    private String msg = "Success";
}
