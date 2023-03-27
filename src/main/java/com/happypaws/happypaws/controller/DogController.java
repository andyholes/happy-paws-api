package com.happypaws.happypaws.controller;

import com.happypaws.happypaws.model.dto.DogRequestDto;
import com.happypaws.happypaws.model.dto.DogResponseDto;
import com.happypaws.happypaws.service.DogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DogResponseDto createDog(@Valid @RequestBody DogRequestDto dog) {
        return dogService.createDog(dog);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDogById(@PathVariable Long id) {
        dogService.deleteDog(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public DogResponseDto getDogById(@PathVariable Long id) {
        return dogService.getDogById(id);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.FOUND)
    public List<DogResponseDto> getAllDogs () {
        return dogService.getAllDogs();
    }
}
