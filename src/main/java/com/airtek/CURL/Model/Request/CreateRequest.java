package com.airtek.CURL.Model.Request;

import com.airtek.CURL.Model.Enums.RequestType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Json model required to create requests")
@Getter @Setter
@NoArgsConstructor
public class CreateRequest {
    private String description;
    private RequestType type;
    private String body;
    private String url;
}
