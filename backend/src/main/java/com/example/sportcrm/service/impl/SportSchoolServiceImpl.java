package com.example.sportcrm.service.impl;

import com.example.sportcrm.dto.SportSchoolRequestDto;
import com.example.sportcrm.dto.SportSchoolResponseDto;
import com.example.sportcrm.mapper.SportSchoolMapper;
import com.example.sportcrm.model.SportSchool;
import com.example.sportcrm.repository.sportSchool.SportSchoolRepository;
import com.example.sportcrm.service.SportSchoolService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SportSchoolServiceImpl implements SportSchoolService {
    private final SportSchoolRepository sportSchoolRepository;
    private final SportSchoolMapper sportSchoolMapper;

    @Override
    public SportSchoolResponseDto createSportSchool(SportSchoolRequestDto sportSchoolRequestDto) {
        SportSchool sportSchool = sportSchoolMapper.toSportSchoolModel(sportSchoolRequestDto);
        return sportSchoolMapper.toResponseDto(sportSchoolRepository.save(sportSchool));
    }

    @Override
    public SportSchoolResponseDto getSportSchoolById(Long id) {
        return sportSchoolRepository.findById(id)
                .map(sportSchoolMapper::toResponseDto)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Can't find sport school by id: " + id
                        ));
    }

    @Override
    public List<SportSchoolResponseDto> getAll() {
        return sportSchoolRepository.findAll()
                .stream()
                .map(sportSchoolMapper::toResponseDto)
                .toList();
    }

    @Override
    public SportSchoolResponseDto updateSportSchool(Long id, SportSchoolRequestDto sportSchoolRequestDto) {
        SportSchool sportSchoolForUpdate = sportSchoolRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Can't find sport school by id: " + id
                        ));
        sportSchoolForUpdate.setName(sportSchoolRequestDto.getName());
        sportSchoolForUpdate.setEmail(sportSchoolRequestDto.getEmail());
        sportSchoolForUpdate.setAddress(sportSchoolForUpdate.getAddress());
        sportSchoolForUpdate.setDescription(sportSchoolRequestDto.getDescription());
        sportSchoolForUpdate.setTelephoneNumber(sportSchoolRequestDto.getTelephoneNumber());
        sportSchoolForUpdate.setTrainerNames(sportSchoolRequestDto.getTrainerNames());
        return sportSchoolMapper.toResponseDto(sportSchoolRepository.save(sportSchoolForUpdate));
    }

    @Override
    public void deleteSportSchoolById(Long id) {
        if (sportSchoolRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Can't delete a sport school with id: " + id);
        }
        sportSchoolRepository.deleteById(id);
    }
}
