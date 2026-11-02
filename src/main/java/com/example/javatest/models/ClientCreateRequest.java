package com.example.javatest.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientCreateRequest {

    @NotBlank(message = "ФИО обязательно")
    @Size(max = 255, message = "ФИО не более 255 символов")
    private String fullName;

    @Pattern(regexp = "^[MF]$", message = "Пол должен быть M или F")
    private String gender;

    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Статус должен быть ACTIVE или INACTIVE")
    private String status;
}
