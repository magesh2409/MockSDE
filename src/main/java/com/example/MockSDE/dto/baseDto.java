package com.example.MockSDE.dto;

import lombok.Data;

public class baseDto {

    @Data
    public static class homeDto{
        private String message;

        public homeDto(String message){
            this.message = message;
        }
    }

    @Data
    public static class healthDto{
        private String status;
        private String message;

        public healthDto(String status, String message){
            this.status = status;
            this.message = message;
        }
    }
}
