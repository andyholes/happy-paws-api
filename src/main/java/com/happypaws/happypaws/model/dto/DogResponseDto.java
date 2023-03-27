package com.happypaws.happypaws.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DogResponseDto {
    private Long id;
    private String name;
    private String profilePicture;
    private Integer age;
    private String description;
}
