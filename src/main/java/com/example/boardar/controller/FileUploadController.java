package com.example.boardar.controller;

import com.example.boardar.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class FileUploadController {

    // fileUploadService class -> @service 붙이니까 에러 없어짐.
    // error :  Could not autowire. No beans of 'FileUploadService' type found.
    private final FileUploadService fileUploadService;



}
