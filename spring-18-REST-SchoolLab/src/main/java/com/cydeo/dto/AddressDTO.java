package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    private AddressType addressType;


    //If we use more than one @JaonBackReference in a DTO we must give value to them to let spring know which one connects to which one. We give the same value to the @JsonManagedReference too.
    @JsonBackReference(value = "student-address-reference")          // defaultReference
    private StudentDTO student;

    @JsonBackReference(value = "parent-address-reference")          // defaultReference
    private ParentDTO parent;

    @JsonBackReference(value = "teacher-address-reference")          // defaultReference
    private TeacherDTO teacher;

    private Integer currentTemperature;

}