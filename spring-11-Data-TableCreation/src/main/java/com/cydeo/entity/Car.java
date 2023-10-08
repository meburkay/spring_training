package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;

    //We can not use @AllArgsConstructor because id is created by Spring automatically. Because of that we create our custom constructor without the id which is primary key.
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}
