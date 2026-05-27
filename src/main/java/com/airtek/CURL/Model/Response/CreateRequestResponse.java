package com.airtek.CURL.Model.Response;

import com.airtek.CURL.Entity.Request;
import com.airtek.CURL.Model.Enums.RequestType;
import com.airtek.CURL.Model.Request.CreateRequestRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Schema(description = "Json model response after creating a shared request")
@Getter @Setter
@NoArgsConstructor
public class CreateRequestResponse {

    private String description;
    private RequestType type;
    private String url;
    private LocalDateTime created;

    public CreateRequestResponse(CreateRequestRequest createRequestRequest) {
        this.description = createRequestRequest.getName();
        this.type = createRequestRequest.getType();
        this.url = createRequestRequest.getUrl();
        this.created = LocalDateTime.now();
    }
}