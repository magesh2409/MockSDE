package com.example.MockSDE.Controller;

import com.example.MockSDE.Dto.BaseDto;
import com.example.MockSDE.Dto.UserRegistration;
import com.example.MockSDE.Repository.UserRepository;
import com.example.MockSDE.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private UserService userService;

    @GetMapping
    private ResponseEntity<BaseDto.homeDto> home(){
        BaseDto.homeDto response = new BaseDto.homeDto("Welcome to Mock SDE Application from Api APP!!!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/health")
    private ResponseEntity<BaseDto.healthDto> health(){
        BaseDto.healthDto response = new BaseDto.healthDto("Healthy", "Server is running healthy from Api APP!!!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/register")
    private ResponseEntity<UserRegistration.UserRegistrationResponse> registerUser(@RequestBody UserRegistration.UserRegistrationRequest payload) {
        UserRegistration.UserRegistrationResponse response = userService.registerUser(payload);
        if(response.getUserId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
