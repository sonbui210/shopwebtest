package com.example.shopwebtest.service;


import com.example.shopwebtest.entities.Customers;
import com.example.shopwebtest.entities.user.Users;
import com.example.shopwebtest.repository.CustomerRepository;
import com.example.shopwebtest.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        result.setData(customerRepository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();

        if (!customerRepository.findById(id).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer not found!");
        } else  {
            result.setData(customerRepository.findById(id));
        }

        return result;

    }

    public ServiceResult create(Customers customers) {
        ServiceResult result = new ServiceResult();

        //customers.setEmail(userRepository.findByEmail(customers.getEmail()));

        result.setData(customerRepository.save(customers));
        result.setMessage("Customer created!");
        return result;
    }

    public ServiceResult update(Customers customers) {

        ServiceResult result = new ServiceResult();

        if (!customerRepository.findById(customers.getCustomerId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer not found!");
        } else {
            result.setData(customerRepository.save(customers));
            result.setMessage("Customer updated!");
        }

        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        Customers customers = customerRepository.findById(id).orElse(null);
        if (customers == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer not found!");
        } else {
            customerRepository.delete(customers);
            result.setMessage("Customer deleted!");
        }

        return result;

    }



}
