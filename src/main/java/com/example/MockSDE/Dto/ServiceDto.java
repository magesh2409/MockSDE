package com.example.MockSDE.Dto;

import com.example.MockSDE.Utils.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class ServiceDto {

    @Data
    public static class CreateService{
        private ObjectId userId;

        @NotBlank
        @NotNull
        @Length( min = 5, max = 100 )
        private String apiKey;
        private String serviceName;

        private LocalDateTime createdAt = LocalDateTime.now();

    }

    @Data
    public static class UpdateService{

        private ObjectId id;
        private ObjectId userId;
        private String apiKey;

        private Constants.ServiceName serviceName;

    }

    @Data
    public static class ServiceResponse {
        private String id;
        private String userId;
        private String message;

        public ServiceResponse(ObjectId id, ObjectId userId, String message){
            this.id = id.toHexString();
            this.userId = userId != null ? userId.toHexString() : null ;
            this.message = message;
        }
    }

    @Data
    public static class GetServiceResponse {
        private String id;
        private String userId;
        private String serviceName;
    }
}
