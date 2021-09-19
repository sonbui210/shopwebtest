package com.example.shopwebtest.service;


import com.example.shopwebtest.entities.Products;
import com.example.shopwebtest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        result.setData(productRepository.findAll());
        return result;

    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();

        if (!productRepository.findById(id).isPresent()) {
            result.setMessage("Product not found!");
        } else {
            result.setData(productRepository.findById(id));
        }
        return result;
    }

    public ServiceResult create(Products products) {
        ServiceResult result = new ServiceResult();
        result.setData(productRepository.save(products));
        result.setMessage("Product created!");
        return result;
    }

    public ServiceResult update(Products products) {
        ServiceResult result = new ServiceResult();

        if (!productRepository.findById(products.getProductId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Product not found!");
        } else {
            result.setData(productRepository.save(products));
            result.setMessage("Product updated!");
        }

        return result;

    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        Products products = productRepository.findById(id).orElse(null);

        if (products == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Product not found!!");
        } else {
            productRepository.delete(products);
            result.setMessage("Product deleted!!");
        }
        return result;

    }




}
