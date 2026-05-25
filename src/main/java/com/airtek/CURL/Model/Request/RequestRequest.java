package com.airtek.CURL.Model.Request;

import com.airtek.CURL.Model.Enums.RequestType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Json model required to create a shared request template")
@Getter @Setter
@NoArgsConstructor
public class RequestRequest {

    private String description;

    @NotNull
    private RequestType type;

    private String body;

    @NotBlank
    private String url;

    @NotNull
    private Long employeeId; // ID del empleado que está guardando la plantilla
}