package com.example.shopwebtest.service;

import com.example.shopwebtest.entities.Categories;
import com.example.shopwebtest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        result.setData(categoryRepository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();

        if (!categoryRepository.findById(id).isPresent()) {
            result.setMessage("Category not found!");
        } else {
            result.setData(categoryRepository.findById(id));
        }
        return result;

    }

    public ServiceResult create(Categories categories) {
        ServiceResult result = new ServiceResult();
        result.setData(categoryRepository.save(categories));
        result.setMessage("Category created!");
        return result;
    }

    public ServiceResult update(Categories categories) {
        ServiceResult result = new ServiceResult();

        if (!categoryRepository.findById(categories.getCategoryId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Category not found!");
        } else {
            result.setData(categoryRepository.save(categories));
            result.setMessage("Category updated!");
        }

        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        Categories categories = categoryRepository.findById(id).orElse(null);

        if (categories == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Category not found!");
        } else {
            categoryRepository.delete(categories);
            result.setMessage("Category deleted!");
        }
        return result;

    }


}
