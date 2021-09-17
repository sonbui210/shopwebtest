package com.example.shopwebtest.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

}
