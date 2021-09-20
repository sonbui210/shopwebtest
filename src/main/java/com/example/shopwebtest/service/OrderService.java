package com.example.shopwebtest.service;


import com.example.shopwebtest.entities.OrderDetail;
import com.example.shopwebtest.entities.Orders;
import com.example.shopwebtest.repository.OrderDetailRepository;
import com.example.shopwebtest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        result.setData(orderRepository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        if (!orderRepository.findById(id).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Order not found!");
        } else {
            result.setData(orderRepository.findById(id));
            result.setMessage("Order found!");
        }
        return  result;
    }

    public ServiceResult create(Orders orders) {
        ServiceResult result = new ServiceResult();

        result.setData(orderRepository.save(orders));
        result.setMessage("Order created!");
        return result;
    }

    public ServiceResult update(Orders orders) {
        ServiceResult result = new ServiceResult();

        if (!orderRepository.findById(orders.getOrderId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Order not found!");
        } else  {
            result.setData(orderRepository.save(orders));
            result.setMessage("Order updated!");
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        Orders orders = orderRepository.findById(id).orElse(null);

        if (orders == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Order not found!!");
        } else {
            orderRepository.delete(orders);
            result.setMessage("Order deleted!");
        }
        return result;
    }



}
