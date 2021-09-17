package com.example.shopwebtest.entities.user;


import com.example.shopwebtest.common.ERole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private ERole name;

}
