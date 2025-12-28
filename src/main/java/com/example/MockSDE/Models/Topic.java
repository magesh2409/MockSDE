package com.example.MockSDE.Models;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;

@Document( collection = "topic")
@Data
public class Topic {

    @Id
    @Generated
    private ObjectId id;

    @NotNull
    private ObjectId agentId;

    @NotNull
    private String topicName;

    @NotNull
    private String description;

    @NotNull
    private String toolType;

    @NotNull
    private HashMap<String,String> hyperParameters;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();
}
