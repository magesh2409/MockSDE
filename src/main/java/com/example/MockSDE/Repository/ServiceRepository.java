package com.example.MockSDE.Repository;

import com.example.MockSDE.Models.Service;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ServiceRepository extends MongoRepository<Service, ObjectId> {

    @Query("{ 'userId' : ?0 }")
    Optional<Service> findByUserId(ObjectId userId);
}
