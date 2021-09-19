package com.example.shopwebtest.service;


import com.example.shopwebtest.entities.OrderDetail;
import com.example.shopwebtest.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        result.setData(orderDetailRepository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();

        if (!orderDetailRepository.findById(id).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Order Detail not found!");
        } else {
            result.setData(orderDetailRepository.findById(id));
        }
        return result;
    }

    public ServiceResult create(OrderDetail orderDetail) {
        ServiceResult result =new ServiceResult();
        result.setData(orderDetailRepository.save(orderDetail));
        result.setMessage("Order Detail created!");
        return result;
    }

    public ServiceResult update(OrderDetail orderDetail) {
        ServiceResult result = new ServiceResult();

        if (!orderDetailRepository.findById(orderDetail.getOrderDetailId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Order Detail not found!");
        } else {
            result.setData(orderDetailRepository.save(orderDetail));
            result.setMessage("Order Detail updated!");
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        OrderDetail orderDetail = orderDetailRepository.findById(id).orElse(null);

        if (orderDetail == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Order Detail not found!");
        } else {
            orderDetailRepository.delete(orderDetail);
            result.setMessage("Order Detail delete!");
        }
        return result;
    }

}
