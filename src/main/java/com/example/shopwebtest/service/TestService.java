package com.example.shopwebtest.service;


import com.example.shopwebtest.entities.Test;
import com.example.shopwebtest.repository.TestReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.Calendar;
import java.util.Date;

@Service
public class TestService {

    @Autowired
    TestReprository testReprository;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();

        result.setData(testReprository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();

        if (!testReprository.findById(id).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Khong tim thay!!");
        } else {
            result.setData(testReprository.findById(id));
        }
        return result;

    }

    public ServiceResult create(Test test) {
        ServiceResult result =new ServiceResult();

        result.setData(testReprository.save(test));
        return result;

    }

    public ServiceResult update(Test test) {
        ServiceResult result= new ServiceResult();

        test.setCreateAt(testReprository.findById(test.getId()).get().getCreateAt());

        if (!testReprository.findById(test.getId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Khong tim thay!!!!");
        } else {
            result.setData(testReprository.save(test));
            result.setMessage("Da update!");
        }
        return result;

    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        Test test = testReprository.findById(id).orElse(null);

        if (test == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Khong tim that test!!");
        } else {
            testReprository.delete(test);
            result.setMessage("Da xoa!");
        }

        return result;

    }


}
