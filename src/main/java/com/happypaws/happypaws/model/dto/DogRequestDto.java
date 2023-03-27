package com.happypaws.happypaws.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DogRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String profilePicture;
    private Integer age;
    @NotBlank
    private String description;
}
