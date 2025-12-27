package com.example.MockSDE.Controller;

import com.example.MockSDE.Dto.BaseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    private ResponseEntity<BaseDto.homeDto> home(){
        BaseDto.homeDto response = new BaseDto.homeDto("Welcome to Mock SDE Application!!!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/health")
    private ResponseEntity<BaseDto.healthDto> health() {
        BaseDto.healthDto response = new BaseDto.healthDto("Healthy", "Server is running healthy!!!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
