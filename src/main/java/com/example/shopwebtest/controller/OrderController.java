package com.example.shopwebtest.controller;


import com.example.shopwebtest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

}
