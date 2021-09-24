package com.example.shopwebtest.controller;


import com.example.shopwebtest.entities.Test;
import com.example.shopwebtest.service.ServiceResult;
import com.example.shopwebtest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    private TestService testService;


    @GetMapping("/test-service")
    public ResponseEntity<ServiceResult> findAll() {
        return new ResponseEntity<ServiceResult>(testService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/test-service/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(testService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/test-service")
    public ResponseEntity<ServiceResult> create(@RequestBody Test test) {
        return new ResponseEntity<ServiceResult>(testService.create(test), HttpStatus.OK);
    }

    @PutMapping("/test-service")
    public ResponseEntity<ServiceResult> update(@RequestBody Test test) {
        return new ResponseEntity<ServiceResult>(testService.update(test), HttpStatus.OK);
    }

    @DeleteMapping("/test-service/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(testService.delete(id), HttpStatus.OK);
    }

}
