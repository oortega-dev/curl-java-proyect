package com.airtek.CURL.Model.Request;

import com.airtek.CURL.Model.Enums.EmployeeType;
import com.airtek.CURL.Model.Enums.Gender;
import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


@Schema(description = "Json model required to create employee")
@Getter @Setter
@NoArgsConstructor
public class EmployeeRequest {

    private String documentId;

    @NotBlank
    @JsonAlias({"Nombre", "nombre", "nombres"})
    private String name;

    @NotBlank
    private String lastName;

    private Gender gender;

    private LocalDateTime birthDate;

    @PositiveOrZero
    @Max(5000)
    private Double income;

    private EmployeeType employeeType;
}
