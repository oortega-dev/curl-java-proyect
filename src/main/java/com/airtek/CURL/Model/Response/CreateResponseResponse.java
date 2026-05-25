package com.airtek.CURL.Model.Response;

import com.airtek.CURL.Entity.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Schema(description = "Json model response after logging an execution result")
@Getter @Setter
@NoArgsConstructor
public class CreateResponseResponse {

    private Long id;
    private Integer code;
    private String status;
    private LocalDateTime created;

    public CreateResponseResponse(Response response) {
        this.id = response.getId();
        this.code = response.getCode();
        this.status = response.getStatus();
        this.created = response.getCreated();
    }
}