package com.example.MockSDE.Models;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document( collection = "agent")
@Data
public class Agent {

    @Id
    @Generated
    private ObjectId id;

    @NotNull
    private ObjectId serviceId;

    @NotNull
    private String modelName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();

}
