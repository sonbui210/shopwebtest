package com.example.shopwebtest.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailId;


//    @ManyToOne
//    @JoinColumn(name = "orderId")
//    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Products products;

    private int quantity;

    private float unitPrice;

}
