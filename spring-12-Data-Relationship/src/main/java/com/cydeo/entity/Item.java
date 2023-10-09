package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    //Whenever we define a relationship like this spring try to create that relationship either with foreign key or table. Because of that when we use a bidirectional way we have to use mappedBy to define one of the tables as a parent. By this way spring create one relationship which is we need.
    @ManyToMany(mappedBy = "itemList")
    private List<Cart> carts;



    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
