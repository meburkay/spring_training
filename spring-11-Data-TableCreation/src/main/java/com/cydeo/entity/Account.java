package com.cydeo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass//means use this class as a parent to other classes but do not create a table from this just create tables from the child classes including this classes columns. If we put @Table instead of this it creates one table from parent and add the childeren's columns into it.
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;

}
