package com.airtek.CURL.Entity;

import com.airtek.CURL.Model.Enums.EmployeeType;
import com.airtek.CURL.Model.Enums.Gender;
import com.airtek.CURL.Model.Request.CreateEmployeeRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(schema = "curl_proyect", name = "employee", indexes = @Index(name = "fn_index_document_id", columnList = "document_id"))
@NoArgsConstructor
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_id_seq", sequenceName = "curl_proyect.employee_id_seq",  allocationSize = 1)
    @GeneratedValue(generator = "curl_proyect.employee_id_seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "document_id", columnDefinition = "text")
    private String documentId;

    @Column(name = "name", columnDefinition = "text")
    private String name;

    @Column(name = "last_name", columnDefinition = "text")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birth_date", columnDefinition = "timestamp")
    private LocalDate birthDate;

    @Column(name = "income", columnDefinition = "numeric")
    private Double income;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type")
    private EmployeeType employeeType;

    @OneToMany(mappedBy = "employee")
    List<Request> Requests;

    public Employee(CreateEmployeeRequest createEmployeeRequest) {
        this.documentId = createEmployeeRequest.getDocumentId();
        this.name = createEmployeeRequest.getName();
        this.lastName = createEmployeeRequest.getLastName();
        this.gender = createEmployeeRequest.getGender();
        this.birthDate = createEmployeeRequest.getBirthDate();
        this.income = createEmployeeRequest.getIncome();
        this.employeeType = createEmployeeRequest.getEmployeeType();
        this.Requests = new ArrayList<>();
    }
}
