package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//We can give list like below for @JsonIgnore
//@JsonIgnoreProperties(value = {"address", "country"}, ignoreUnknown = true)
//ignoreUnknown means ignore the data that is unknown. Normally it ignores but as a best practice we must use like this for a second security about the unknown files.
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    @JsonIgnore//Ignores the field when consuming or sending in both ways.
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;
    //In general this annotation used with @JsonManagedReference annotation. We use this annotations when a collision happens between two classes like here. Here we have user and account dto and they have each others field at the same time. Because of that we use this annotations on them to solve the issue. BackReference annotation field will not serialized (When we retrieve account data from the api we won't see the user information) and the other feild which is account belongs to user will be serialized. By this we solve the collision issue here.
    @JsonBackReference  // This field is not going to be serialized
    private UserDTO user;

}
