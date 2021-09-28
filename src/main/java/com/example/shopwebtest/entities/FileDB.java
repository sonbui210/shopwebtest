package com.example.shopwebtest.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "files")
public class FileDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    public FileDB() {

    }

    public FileDB(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

}
