package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "students")//Normally when you use only @Entity annotation Spring create a table with "student" name. But you can change that with @Table annotation. To do that and give the table name plural is the best practice. Because it is a table that consist of students.
public class Student {

    @Id//means primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//means that spring you take the primary key responsibility.
    private Long id;

    @Column(name = "studentFirstName")//change the column name
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")//seting the column type
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDateTime;

    @Enumerated(EnumType.STRING)//For enums we use this annotation to change it to String. Otherwise it is understanded as integer as a default.
//    @Enumerated(EnumType.ORDINAL) // this is the default form.
    private Gender gender;
}
