package com.airtek.CURL.Model.Response;

import com.airtek.CURL.Entity.Request;
import com.airtek.CURL.Model.Enums.RequestType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Schema(description = "Json model response to get detailed shared request data")
@Getter @Setter
@NoArgsConstructor
public class GetRequestResponse {

    private String description;
    private RequestType type;
    private String body;
    private String url;
    private LocalDateTime created;
    private GetEmployeeResponse createdBy; // Mapea el DTO del empleado que ya hiciste

    public GetRequestResponse(Request Request) {
        this.description = Request.getName();
        this.type = Request.getType();
        this.body = Request.getBody();
        this.url = Request.getUrl();
        this.created = Request.getCreated();

        if (Request.getEmployee() != null) {
            this.createdBy = new GetEmployeeResponse(Request.getEmployee());
        }
    }
}