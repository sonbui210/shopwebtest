package com.example.shopwebtest.controller;


import com.example.shopwebtest.entities.Categories;
import com.example.shopwebtest.service.CategoryService;
import com.example.shopwebtest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<ServiceResult> findAll() {
        return new ResponseEntity<ServiceResult>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<ServiceResult> create(@RequestBody Categories categories) {
        return new ResponseEntity<ServiceResult>(categoryService.create(categories), HttpStatus.OK);
    }

    @PutMapping("/category")
    public ResponseEntity<ServiceResult> update(@RequestBody Categories categories) {
        return new ResponseEntity<ServiceResult>(categoryService.update(categories), HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(categoryService.delete(id), HttpStatus.OK);
    }

}
