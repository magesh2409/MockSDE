package com.example.MockSDE.Utils;

public class Constants {

    public static class Registration {
        public static final String SUCCESS = "Your Registration is successful. Please login.";
        public static final String USER_EXISTS = "User already exists. Please login.";
        public static final String FAILED = "User registration failed. Please try again.";
    }

    public static enum UserStatus{
        ACTIVE,
        INACTIVE,
        SUSPENDED
    }

    public static enum ServiceName{
        OPENAI,
        GEMINI
    }
}
