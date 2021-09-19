package com.example.shopwebtest.controller;


import com.example.shopwebtest.entities.Customers;
import com.example.shopwebtest.service.CustomerService;
import com.example.shopwebtest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<ServiceResult> findAll() {
        return new ResponseEntity<ServiceResult>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<ServiceResult> create(@RequestBody Customers customers) {
        return new ResponseEntity<ServiceResult>(customerService.create(customers), HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity<ServiceResult> update(@RequestBody Customers customers) {
        return new ResponseEntity<ServiceResult>(customerService.update(customers), HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(customerService.delete(id), HttpStatus.OK);
    }

}
