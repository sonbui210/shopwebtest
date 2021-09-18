package com.example.shopwebtest.repository;

import com.example.shopwebtest.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {
}
