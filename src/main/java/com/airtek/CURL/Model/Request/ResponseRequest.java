package com.airtek.CURL.Model.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Json model required to log a new execution response")
@Getter @Setter
@NoArgsConstructor
public class ResponseRequest {

    @NotNull
    private Long requestId; // Sobre qué plantilla compartida se está disparando

    private String status;

    @NotNull
    private Integer code; // Código HTTP (200, 404, 500, etc)

    private String body; // El JSON o texto crudo que devolvió la API externa

    @NotNull
    private Integer timeDelay; // Tiempo de respuesta medido en milisegundos
}