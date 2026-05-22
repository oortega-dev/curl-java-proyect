package com.airtek.CURL.Entity;

import com.airtek.CURL.Model.Enums.RequestType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(schema = "curl_proyect", name = "request")
public class Request {
    @Id
    @SequenceGenerator(name = "request_id_seq", sequenceName = "curl_proyect.request_id_seq",  allocationSize = 1)
    @GeneratedValue(generator = "curl_proyect.request_id_seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RequestType type;

    @Column(name = "body", columnDefinition = "text")
    private String body;

    @Column(name = "url", columnDefinition = "text")
    private String url;

    @Column(name = "created", columnDefinition = "timestamp")
    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Employee employee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "response_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Response response;

}
