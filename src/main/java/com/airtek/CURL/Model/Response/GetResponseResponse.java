package com.airtek.CURL.Model.Response;

import com.airtek.CURL.Entity.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Schema(description = "Json model response to audit what a request execution returned and who triggered it")
@Getter @Setter
@NoArgsConstructor
public class GetResponseResponse {

    private Long id;
    private String status;
    private Integer code;
    private String body;
    private LocalDateTime created;
    private Integer timeDelay;

    // Datos de la plantilla y de QUIÉN provocó esta respuesta
    private Long requestId;
    private String requestDescription;
    private GetEmployeeResponse executedBy;

    public GetResponseResponse(Response response) {
        this.id = response.getId();
        this.status = response.getStatus();
        this.code = response.getCode();
        this.body = response.getBody();
        this.created = response.getCreated();
        this.timeDelay = response.getTimeDelay();

        if (response.getRequest() != null) {
            this.requestId = response.getRequest().getId();
            this.requestDescription = response.getRequest().getDescription();

            // Accedemos al empleado asociado a esa plantilla para saber quién mapeó el evento
            if (response.getRequest().getEmployee() != null) {
                this.executedBy = new GetEmployeeResponse(response.getRequest().getEmployee());
            }
        }
    }
}