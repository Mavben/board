package com.example.boardar.controller;

import com.example.boardar.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class FileUploadController {

    private final FileUploadService fileUploadService;

}
