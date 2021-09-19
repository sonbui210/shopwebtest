package com.example.shopwebtest.controller;


import com.example.shopwebtest.entities.Products;
import com.example.shopwebtest.service.ProductService;
import com.example.shopwebtest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<ServiceResult> findAll() {
        return new ResponseEntity<ServiceResult>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<ServiceResult> create(@RequestBody Products products) {
        return new ResponseEntity<ServiceResult>(productService.create(products), HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<ServiceResult> update(@RequestBody Products products) {
        return new ResponseEntity<ServiceResult>(productService.update(products), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(productService.delete(id), HttpStatus.OK);
    }

}
