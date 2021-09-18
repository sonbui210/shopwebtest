package com.example.shopwebtest.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    private String name;

}
