package com.example.MockSDE.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
public class User {

    @Id
    @Generated
    private ObjectId id;

    @NotBlank
    @NotNull
    @Length(min = 2, max = 50)
    private String name;

    @Email
    private String email;

    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();

}
