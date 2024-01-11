package com.example.sportcrm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class SportSchoolRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    private String description;
    @NotBlank
    private String telephoneNumber;
    @Email
    @NotBlank
    private String email;
    @NotNull
    private List<String> trainerNames;
}
