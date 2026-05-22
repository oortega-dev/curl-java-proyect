package com.airtek.CURL.Entity;

import com.airtek.CURL.Model.Enums.Gender;
import com.airtek.CURL.Model.Request.CreateEmployeeRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Entity
@Getter @Setter
@Table(schema = "curl_proyect", name = "employee")
@NoArgsConstructor
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_id_seq", sequenceName = "curl_proyect.employee_id_seq",  allocationSize = 1)
    @GeneratedValue(generator = "curl_proyect.employee_id_seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "document_id")
    private String documentId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birth_date")
    private Timestamp birthDate;

    @Column(name = "income")
    private Double income;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeType")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private EmployeeType employeeType;

    public Employee(CreateEmployeeRequest createEmployeeRequest, EmployeeType employeeType) {
        this.documentId = createEmployeeRequest.getDocumentId();
        this.name = createEmployeeRequest.getName();
        this.lastName = createEmployeeRequest.getLastName();
        this.gender = createEmployeeRequest.getGender();
        this.birthDate = createEmployeeRequest.getBirthDate();
        this.income = createEmployeeRequest.getIncome();
        this.employeeType = employeeType;
    }
}
