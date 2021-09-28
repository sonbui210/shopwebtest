package com.example.shopwebtest.controller;


import com.example.shopwebtest.entities.FileDB;
import com.example.shopwebtest.message.ResponseFile;
import com.example.shopwebtest.service.FileStorageService;
import com.example.shopwebtest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("/api/test")
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<ServiceResult> uploadFile(@RequestParam("file") MultipartFile file) {
        ServiceResult result = new ServiceResult();
        result.setMessage(" ");
        String message = " ";
        try {
            fileStorageService.store(file);

            result.setMessage("Upload the file successfully: " + file.getOriginalFilename());
            return new ResponseEntity<ServiceResult>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.setMessage("Could not upload file: " + file.getOriginalFilename() + "!");
            return new ResponseEntity<ServiceResult>(result, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = fileStorageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("api/test/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length
            );
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        FileDB fileDB = fileStorageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }

}
