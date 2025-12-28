package com.example.MockSDE.Dto;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

public class UserRegistration {

    @Data
    public static class UserRegistrationRequest{

        @Length(min = 2, max = 50)
        private String name;

        @Email
        private String email;
        private String password;

        public UserRegistrationRequest(String name, String email, String password){
            this.name = name;
            this.email = email;
            this.password = password;
        }

    }

    @Data
    public static class UserRegistrationResponse{
        private String userId;
        private String message;
        private boolean isUserExist;

        public UserRegistrationResponse(String userId, String message, boolean isUserExist){
            this.userId = userId;
            this.message = message;
            this.isUserExist = isUserExist;
        }
    }
}
