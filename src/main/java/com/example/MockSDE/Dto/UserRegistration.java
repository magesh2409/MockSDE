package com.example.MockSDE.Dto;

import lombok.Data;

public class UserRegistration {

    @Data
    public static class UserRegistrationRequest{
        private String name;
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
