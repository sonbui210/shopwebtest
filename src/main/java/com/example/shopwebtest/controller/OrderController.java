package com.example.shopwebtest.controller;


import com.example.shopwebtest.entities.Orders;
import com.example.shopwebtest.service.OrderService;
import com.example.shopwebtest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<ServiceResult> findAll() {
        return new ResponseEntity<ServiceResult>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(orderService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<ServiceResult> create(@RequestBody Orders orders) {
        return new ResponseEntity<ServiceResult>(orderService.create(orders), HttpStatus.OK);
    }

    @PutMapping("/order")
    public ResponseEntity<ServiceResult> update(@RequestBody Orders orders) {
        return new ResponseEntity<ServiceResult>(orderService.update(orders), HttpStatus.OK);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(orderService.delete(id), HttpStatus.OK);
    }


}
