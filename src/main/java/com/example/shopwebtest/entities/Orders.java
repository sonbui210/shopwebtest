package com.example.shopwebtest.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customers customers;

    private float amount;

    private int status;

}
