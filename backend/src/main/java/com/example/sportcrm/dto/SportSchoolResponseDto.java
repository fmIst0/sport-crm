package com.example.sportcrm.dto;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class SportSchoolResponseDto {
    private Long id;
    private String name;
    private String address;
    private String description;
    private String telephoneNumber;
    private String email;
    private List<String> trainerNames;
}
