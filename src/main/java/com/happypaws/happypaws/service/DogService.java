package com.happypaws.happypaws.service;

import com.happypaws.happypaws.model.DogEntity;
import com.happypaws.happypaws.model.dto.DogRequestDto;
import com.happypaws.happypaws.model.dto.DogResponseDto;
import com.happypaws.happypaws.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public DogResponseDto createDog (DogRequestDto dto){
        return mapToDto(dogRepository.save(mapToEntity(dto)));
    }

    public DogResponseDto getDogById (Long id){
        if (dogRepository.findById(id).isPresent()){
            return mapToDto(dogRepository.findById(id).get());
        }else {
            throw new IllegalArgumentException("No dogs where found by given id");
        }
    }

    public List<DogResponseDto> getAllDogs (){
        List<DogEntity> dogs = dogRepository.findAll();
        return dogs.stream().map(this::mapToDto).toList();
    }

    public void deleteDog (Long id){
     if (dogRepository.findById(id).isPresent()){
         dogRepository.deleteById(id);
     }else {
         throw new IllegalArgumentException("No dogs where found by given id");
     }
    }

    private DogEntity mapToEntity(DogRequestDto dto){
        return DogEntity.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .profilePicture(dto.getProfilePicture())
                .description(dto.getDescription())
                .build();
    }

    private DogResponseDto mapToDto(DogEntity dog){
        return DogResponseDto.builder()
                .id(dog.getId())
                .name(dog.getName())
                .age(dog.getAge())
                .profilePicture(dog.getProfilePicture())
                .description(dog.getDescription())
                .build();
    }
}
