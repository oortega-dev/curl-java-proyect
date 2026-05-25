package com.airtek.CURL.Entity;

import com.airtek.CURL.Model.Request.ResponseRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(schema = "curl_proyect", name = "response") // Corregido el esquema de "project" a "proyect"
public class Response {

    @Id
    @SequenceGenerator(name = "response_id_seq", sequenceName = "curl_proyect.response_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "response_id_seq", strategy = GenerationType.SEQUENCE) // Corregido el generator
    private Long id;

    @Column(name = "status", columnDefinition = "text")
    private String status;

    @Column(name = "code", columnDefinition = "integer")
    private Integer code;

    @Column(name = "body", columnDefinition = "text")
    private String body;

    @Column(name = "created", columnDefinition = "timestamp")
    private LocalDateTime created;

    @Column(name = "time_delay", columnDefinition = "integer") // Cambiado a snake_case, buena práctica en SQL
    private Integer timeDelay;

    // Cambiado de @OneToOne a @ManyToOne: Muchas respuestas pertenecen a un mismo Request de origen
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Request request;

    // Nota: El "Employee" (Usuario) que arrojó el response se obtiene directamente navegando
    // a través del objeto Request (response.getRequest().getEmployee()) cuando se consulta el historial.

    public Response(ResponseRequest response, Request request) {
        this.status = response.getStatus();
        this.code = response.getCode();
        this.body = response.getBody();
        this.created = LocalDateTime.now();
        this.timeDelay = response.getTimeDelay();
        this.request = request;
    }
}