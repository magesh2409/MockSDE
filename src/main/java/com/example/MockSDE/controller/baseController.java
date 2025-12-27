package com.example.MockSDE.controller;

import com.example.MockSDE.dto.baseDto;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class baseController {

    @GetMapping("/")
    private ResponseEntity<baseDto.homeDto> home(){
        baseDto.homeDto response = new baseDto.homeDto("Welcome to Mock SDE Application!!!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/health")
    private ResponseEntity<baseDto.healthDto> health() {
        baseDto.healthDto response = new baseDto.healthDto("Healthy", "Server is running healthy!!!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
