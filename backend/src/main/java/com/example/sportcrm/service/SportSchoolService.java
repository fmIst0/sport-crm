package com.example.sportcrm.service;

import com.example.sportcrm.dto.SportSchoolRequestDto;
import com.example.sportcrm.dto.SportSchoolResponseDto;
import java.util.List;

public interface SportSchoolService {
    SportSchoolResponseDto createSportSchool(SportSchoolRequestDto sportSchoolRequestDto);

    SportSchoolResponseDto getSportSchoolById(Long id);

    List<SportSchoolResponseDto> getAll();

    SportSchoolResponseDto updateSportSchool(Long id, SportSchoolRequestDto sportSchoolRequestDto);

    void deleteSportSchoolById(Long id);
}
