package com.example.shopwebtest;

import com.example.shopwebtest.service.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ShopwebtestApplication implements CommandLineRunner {

    @Resource
    FilesStorageService filesStorageService;

    public static void main(String[] args) {
        SpringApplication.run(ShopwebtestApplication.class, args);

    }

    @Override
    public void run(String... arg) throws Exception {
        filesStorageService.deleteAll();
        filesStorageService.init();
    }

}