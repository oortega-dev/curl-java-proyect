package com.airtek.CURL.Model.Response;

import com.airtek.CURL.Entity.Request;
import com.airtek.CURL.Model.Enums.RequestType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Schema(description = "Json model response after creating a shared request")
@Getter @Setter
@NoArgsConstructor
public class CreateRequestResponse {

    private Long id;
    private String description;
    private RequestType type;
    private String url;
    private LocalDateTime created;

    public CreateRequestResponse(Request request) {
        this.id = request.getId();
        this.description = request.getDescription();
        this.type = request.getType();
        this.url = request.getUrl();
        this.created = request.getCreated();
    }
}