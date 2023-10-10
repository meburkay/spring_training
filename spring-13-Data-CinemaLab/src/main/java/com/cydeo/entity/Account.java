package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "account_details")
public class Account extends BaseEntity {

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    //TODO Why did we add this user instance and configure by mappedBy here if we do not want to add any column about it into this table. According to what we create bidirectional or unidirectional relationships.
    @OneToOne(mappedBy = "account")
    private User user;
}
