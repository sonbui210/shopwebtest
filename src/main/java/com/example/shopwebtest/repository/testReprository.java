package com.example.shopwebtest.repository;

import com.example.shopwebtest.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface testReprository extends JpaRepository<Test, Integer> {
}
