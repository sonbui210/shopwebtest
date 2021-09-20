package com.example.shopwebtest.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private Date orderDate;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customers customers;

    private float amount;

    private int status;

//    @JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "orders")
//    private Set<OrderDetail> orderDetails = new HashSet<>();

}
