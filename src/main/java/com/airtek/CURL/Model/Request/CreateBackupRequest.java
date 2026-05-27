package com.airtek.CURL.Model.Request;

import com.airtek.CURL.Entity.Employee;
import com.airtek.CURL.Model.Enums.RequestType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class CreateBackupRequest {

    @NotNull
    private String name;

    @NotNull
    private RequestType typeChanged;

    private String bodyChanged;

    @NotBlank
    private String urlChanged;
}
