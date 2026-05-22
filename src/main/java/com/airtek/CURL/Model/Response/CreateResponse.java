package com.airtek.CURL.Model.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Schema(description = "Json model required to create responses")
@Getter @Setter
@NoArgsConstructor
public class CreateResponse {
    private String status;
    private Integer code;
    private String body;
    private Integer timeDelay;

}
