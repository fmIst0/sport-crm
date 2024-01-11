package com.example.sportcrm.mapper;

import com.example.sportcrm.config.MapperConfig;
import com.example.sportcrm.dto.SportSchoolRequestDto;
import com.example.sportcrm.dto.SportSchoolResponseDto;
import com.example.sportcrm.model.SportSchool;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SportSchoolMapper {
    SportSchoolResponseDto toResponseDto(SportSchool sportSchool);

    SportSchool toSportSchoolModel(SportSchoolRequestDto sportSchoolRequestDto);
}
