package com.example.MockSDE.Models;

import com.example.MockSDE.Utils.Constants;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document( collection = "service")
@Data
public class Service {

    @Id
    private ObjectId id;

    private Constants.ServiceName serviceName;
    private String apiKey;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();

}
