package com.example.shopwebtest.entities;


import com.example.shopwebtest.entities.user.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "customers")
@JsonIgnoreProperties({"password"})
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String name;


    //tam thoi de vay, sau do lien ket voi tai khoan sau

    private String email;

    private String password;

    private String phone;

    private Date registerDated;

    private int status;

    @JsonIgnore
//    @JsonIgnoreProperties({"password", "roles", "email"})
    @OneToOne
    @JoinColumn(name = "users_id")
    private Users users;

}
