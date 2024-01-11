package com.example.sportcrm.controller;

import com.example.sportcrm.dto.SportSchoolRequestDto;
import com.example.sportcrm.dto.SportSchoolResponseDto;
import com.example.sportcrm.service.SportSchoolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Sport schools management", description = "Sport schools endpoints")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/sport-schools")
public class SportSchoolController {
    private final SportSchoolService sportSchoolService;

    @GetMapping
    @Operation(summary = "Get a list of all sport schools",
            description = "Get a list of all available(NOT DELETED) schools")
    public List<SportSchoolResponseDto> getAll() {
        return sportSchoolService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get school by its id", description = "Get school by its id")
    public SportSchoolResponseDto getSportSchoolById(@PathVariable Long id) {
        return sportSchoolService.getSportSchoolById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new schools(FOR ADMINS)",
            description = "Create a new sport school")
    public SportSchoolResponseDto createSportSchool(
            @RequestBody @Valid SportSchoolRequestDto sportSchoolRequestDto) {
        return sportSchoolService.createSportSchool(sportSchoolRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Update an existing school(FOR ADMINS)",
            description = "Update an existing school")
    public SportSchoolResponseDto updateBook(
            @PathVariable Long id,
            @RequestBody @Valid SportSchoolRequestDto sportSchoolRequestDto) {
        return sportSchoolService.updateSportSchool(id, sportSchoolRequestDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a school by id(FOR ADMINS)", description = "Delete a school by id")
    public void deleteSportSchoolById(@PathVariable Long id) {
        sportSchoolService.deleteSportSchoolById(id);
    }
}
