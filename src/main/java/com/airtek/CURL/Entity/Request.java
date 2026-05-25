package com.airtek.CURL.Entity;

import com.airtek.CURL.Model.Enums.RequestType;
import com.airtek.CURL.Model.Request.RequestRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(schema = "curl_proyect", name = "request")
public class Request {

    @Id
    @SequenceGenerator(name = "request_id_seq", sequenceName = "curl_proyect.request_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "request_id_seq", strategy = GenerationType.SEQUENCE) // Corregido el generator
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

    // Cambiado de @OneToOne a @OneToMany: Un Request acumulado tiene muchas respuestas históricas
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Response> responses = new ArrayList<>();

    // Constructor limpio: Un request compartido nace sin respuestas aún
    public Request(RequestRequest request, Employee employee) {
        this.description = request.getDescription();
        this.type = request.getType();
        this.body = request.getBody();
        this.url = request.getUrl();
        this.created = LocalDateTime.now();
        this.employee = employee;
    }
}