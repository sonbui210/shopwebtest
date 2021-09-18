package com.example.shopwebtest.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String name;

    private String email;

    //tam thoi de vay, sau do lien ket voi tai khoan sau
    private String password;

    private String phone;

    private Date registerDated;

    private int status;

}
