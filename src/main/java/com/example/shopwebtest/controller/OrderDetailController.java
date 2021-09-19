package com.example.shopwebtest.controller;


import com.example.shopwebtest.entities.OrderDetail;
import com.example.shopwebtest.service.OrderDetailService;
import com.example.shopwebtest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/order-detail")
    public ResponseEntity<ServiceResult> findAll() {
        return new ResponseEntity<ServiceResult>(orderDetailService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/order-detail/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(orderDetailService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/order-detail")
    public ResponseEntity<ServiceResult> create(@RequestBody OrderDetail orderDetail) {
        return new ResponseEntity<ServiceResult>(orderDetailService.create(orderDetail), HttpStatus.OK);
    }

    @PutMapping("/order-detail")
    public ResponseEntity<ServiceResult> update(@RequestBody OrderDetail orderDetail) {
        return new ResponseEntity<ServiceResult>(orderDetailService.update(orderDetail), HttpStatus.OK);
    }

    @DeleteMapping("/order-detail/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(orderDetailService.delete(id), HttpStatus.OK);
    }


}
