package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//This annotation means that this class will be a table at the database.
public class Employee {

    @Id//Primary key annotation
    private int id;
    private  String name;



}
