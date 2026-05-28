package com.airtek.CURL.Model.Response;

import com.airtek.CURL.Entity.Employee;
import com.airtek.CURL.Model.Enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class GetEmployeeResponse {
    private String documentId;
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
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
