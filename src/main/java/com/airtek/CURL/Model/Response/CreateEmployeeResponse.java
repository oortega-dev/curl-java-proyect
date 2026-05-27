package com.airtek.CURL.Model.Response;

import com.airtek.CURL.Model.Enums.Gender;
import com.airtek.CURL.Model.Request.CreateEmployeeRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(description = "Json model response to create employee")
@Getter
@Setter
@NoArgsConstructor
public class CreateEmployeeResponse {

    @JsonProperty("NOMBRES")
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDateTime birthDate;
    private Double income;

    public CreateEmployeeResponse(CreateEmployeeRequest createEmployeeRequest) {
        this.name = createEmployeeRequest.getName();
        this.lastName = createEmployeeRequest.getLastName();
        this.gender = createEmployeeRequest.getGender();
        this.birthDate = createEmployeeRequest.getBirthDate();
        this.income = createEmployeeRequest.getIncome();
    }
}
