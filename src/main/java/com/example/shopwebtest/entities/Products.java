package com.example.shopwebtest.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String name;

    private int quantity;

    private float unitPrice;

    private String image;

    private String description;

    private float discount;

    private Date enteredDate;

    private int status;


    //many to one category

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Categories categories;

}
