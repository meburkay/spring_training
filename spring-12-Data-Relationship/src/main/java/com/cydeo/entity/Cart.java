package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "cart_item_rel", joinColumns = @JoinColumn(name = "c_id"), inverseJoinColumns = @JoinColumn(name = "i_id")) //Here we give names to the join table and its columns. We can not use cascade here because the relationship is many to many, and we need another table to specify the relationships between the tables.
    private List<Item> itemList;

}
