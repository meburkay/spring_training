package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//In general the 2 lines below is used for all the dto classes. To use them is best practice.
@JsonIgnoreProperties(ignoreUnknown = true)
//This means include our datas only the nonnull datas/fields. If when the converting operation the field is null ignore it, do not show it.
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {

    @JsonIgnore
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

    // Weather information, which we will later get it from 3rd party API
    private Integer currentTemperature;

}