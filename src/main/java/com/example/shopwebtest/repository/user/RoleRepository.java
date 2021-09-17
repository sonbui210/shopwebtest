package com.example.shopwebtest.repository.user;


import com.example.shopwebtest.common.ERole;
import com.example.shopwebtest.entities.user.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByName(ERole name);

}
