package com.example.shopwebtest.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailId;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders orders;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productId")
    private Products products;

    private int quantity;

    private float unitPrice;

}
