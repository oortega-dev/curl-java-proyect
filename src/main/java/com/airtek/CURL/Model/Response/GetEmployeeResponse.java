package com.airtek.CURL.Model.Response;

import com.airtek.CURL.Entity.Employee;
import com.airtek.CURL.Entity.Request;
import com.airtek.CURL.Model.Enums.Gender;

import java.time.LocalDateTime;
import java.util.List;

public class GetEmployeeResponse {
    private String documentId;
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDateTime birthDate;
    private Double income;

    public GetEmployeeResponse(Employee employee) {
        this.documentId = employee.getDocumentId();
        this.name = employee.getName();
        this.lastName = employee.getLastName();
        this.gender = employee.getGender();
        this.birthDate = employee.getBirthDate();
        this.income = employee.getIncome();
    }


}
