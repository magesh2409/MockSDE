package com.example.MockSDE.Models;

import com.example.MockSDE.Utils.Constants;
import lombok.Data;
import lombok.Generated;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document( collection = "service")
@Data
public class Service {

    @Id
    @Generated
    private ObjectId id;

    private ObjectId userId;

    private Constants.ServiceName serviceName;
    private String apiKey;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();

}
