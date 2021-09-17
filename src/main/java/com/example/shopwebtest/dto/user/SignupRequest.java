package com.example.shopwebtest.dto.user;


import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {

    private String username;

    private String email;

    private String password;

    private Set<String> role;

}
