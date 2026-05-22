package com.airtek.CURL.Entity;

import com.airtek.CURL.Model.Response.CreateResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(schema = "curl_project", name = "response")
public class Response {

    @Id
    @SequenceGenerator(name = "response_id_seq", sequenceName = "curl_proyect.response_id_seq",  allocationSize = 1)
    @GeneratedValue(generator = "curl_proyect.response_id_seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "status", columnDefinition = "text")
    private String status;

    @Column(name = "code", columnDefinition = "integer")
    private Integer code;

    @Column(name = "body", columnDefinition = "text")
    private String body;

    @Column(name = "created", columnDefinition = "timestamp")
    private LocalDateTime created;

    @Column(name = "timeDelay", columnDefinition = "integer")
    private Integer timeDelay;

    @OneToOne(mappedBy = "response")
    private Request request;

    public Response(CreateResponse response, Request request) {
        this.status = response.getStatus();
        this.code = response.getCode();
        this.body = response.getBody();
        this.created = LocalDateTime.now();
        this.timeDelay = response.getTimeDelay();
        this.request = request;
    }
}
