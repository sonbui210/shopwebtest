package com.example.shopwebtest.service;


import com.example.shopwebtest.entities.Test;
import com.example.shopwebtest.repository.TestReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

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

        test.setTong(test.getA() + test.getB());
        try {
            float testException = test.getA()/test.getB();
            test.setThuong(testException);
            result.setMessage("Ket qua la " + testException);
        } catch (ArithmeticException e) {
            result.setMessage("So chia het cho 0 khong thoa man");
        }
        // mang 9 so bao gom xxx.xxx.xxx

        int isbn = test.getIsnb();

        int tongisbn= 0;
        for (int i = 1; i < 10; i++) {
            //System.out.println(Math.floor(isbn/Math.pow(10,9-i)));
            tongisbn+=(Math.floor(isbn/Math.pow(10,9-i))*i);
            System.out.println(tongisbn);
            isbn = (int)(isbn%Math.pow(10,(9-i)));
            //System.out.println(isbn);
        }
        System.out.println(tongisbn);
        int check = tongisbn%11;
        if (check != 10) {
            test.setIsnbcheck(test.getIsnb()*10 + check );
            System.out.println(test.getIsnbcheck());
        } else {
            test.setIsnbcheck(test.getIsnb());
            System.out.println(test.getIsnbcheck());
        }



        result.setData(testReprository.save(test));
        return result;

    }

    public ServiceResult update(Test test) {
        ServiceResult result= new ServiceResult();

        if (!testReprository.findById(test.getId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Khong tim thay!!!!");
        } else {
            test.setTong(test.getA() + test.getB());
            try {
                float testException = test.getA()/test.getB();
                test.setThuong(testException);
                result.setMessage("Ket qua la " + testException);
            } catch (ArithmeticException e) {
                result.setMessage("So chia het cho 0 khong thoa man");
            }
            test.setCreateAt(testReprository.findById(test.getId()).get().getCreateAt());
            result.setData(testReprository.save(test));
            //result.setMessage("Da update!");
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
