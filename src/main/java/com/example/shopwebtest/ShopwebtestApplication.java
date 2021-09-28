package com.example.shopwebtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopwebtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopwebtestApplication.class, args);

        try {
            System.out.println("Starting of try block");
            throw new MyException("This is my error messsage");
        } catch (MyException e) {
            System.out.println("Catch block");
            System.out.println(e);
        }

    }

}

class MyException extends Exception{
    String str1;

    MyException(String str2) {
        str1 = str2;
    }
    public String toString() {
        return ("MyException occurred: " + str1);
    }
}