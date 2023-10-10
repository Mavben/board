package com.example.boardar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("dao")
public class BoardArApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardArApplication.class, args);
    }

}
