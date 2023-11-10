package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    @JsonIgnore//This is a jackson annotation which is responsible for mapping dtos to json or json body to dtos. This annotation means do not include this to json body when converting/mapping.
    private Long id;
    private String name;
    private String category;
    private int rating;
    private String description;

}
