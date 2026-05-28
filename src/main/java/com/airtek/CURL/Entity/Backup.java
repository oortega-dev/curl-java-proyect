package com.airtek.CURL.Entity;

import com.airtek.CURL.Model.Enums.RequestType;
import com.airtek.CURL.Model.Request.CreateBackupRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(schema = "curl_proyect", name = "backup")
public class Backup {
    @Id
    @SequenceGenerator(name = "backup_id_seq", sequenceName = "curl_proyect.backup_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "backup_id_seq", strategy = GenerationType.SEQUENCE) // Corregido el generator
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_changed")
    @Enumerated(EnumType.STRING)
    private RequestType typeChanged;

    @Column(name = "body_changed", columnDefinition = "text")
    private String bodyChanged;

    @Column(name = "url_changed", columnDefinition = "text")
    private String urlChanged;

    @Column(name = "modified", columnDefinition = "timestamp")
    private LocalDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id")
    @JsonIgnoreProperties({"hibernateLazyInitializar", "handler"})
    private Request originalRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Employee employeeChange;

    // Constructor limpio: Un request compartido nace sin respuestas aún
    public Backup(CreateBackupRequest createBackupRequest, Request request, Employee employeeChange) {
        this.name = request.getName();
        this.typeChanged = createBackupRequest.getTypeChanged();
        this.bodyChanged = createBackupRequest.getBodyChanged();
        this.urlChanged = createBackupRequest.getUrlChanged();
        this.modified = LocalDateTime.now();
        this.employeeChange = employeeChange;
    }
}
