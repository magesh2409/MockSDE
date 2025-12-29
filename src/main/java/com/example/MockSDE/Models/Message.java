package com.example.MockSDE.Models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document( collection = "message")
@Data
public class Message {

    @Id
    @Generated
    private ObjectId id;

    @NotNull
    @NotBlank
    private ObjectId threadId;

    private String role;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();
}
