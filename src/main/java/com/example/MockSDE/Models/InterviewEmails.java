package com.example.MockSDE.Models;

import lombok.Data;
import lombok.Generated;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document( collection = "interviewEmails")
@Data
public class InterviewEmails {

    @Id
    @Generated
    private ObjectId id;

    private ObjectId interviewId;
    private ObjectId senderId;
    private ObjectId recipientId;

    private String recipientEmail;
    private String subject;
    private String body;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();
}
