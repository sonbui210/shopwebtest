package com.example.shopwebtest.entities;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    private Calendar dateTest = Calendar.getInstance();

    private int day = dateTest.get(Calendar.DAY_OF_MONTH);

    private int month = dateTest.get(Calendar.MONTH);

    private int year = dateTest.get(Calendar.YEAR);

    private int hour = dateTest.get(Calendar.HOUR);

    private int hour2 = dateTest.get(Calendar.HOUR_OF_DAY);

    private int minute = dateTest.get(Calendar.MINUTE);

    private int second = dateTest.get(Calendar.SECOND);

    @Column(nullable = true)
    private int a;

    @Column(nullable = true)
    private int b;

    @Column(nullable = true)
    private double thuong;

    @Column(nullable = true)
    private int tong;

    @Column(nullable = true)
    private int isnb;

    @Column(nullable = true)
    private int isnbcheck;

}
