package com.example.MockSDE.Models;

import lombok.Data;
import lombok.Generated;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document( collection = "contextData")
@Data
public class ContextData {

    @Id
    @Generated
    private ObjectId id;

    private ObjectId contextId;

    private String filePath;
    private String s3Url;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();

}
