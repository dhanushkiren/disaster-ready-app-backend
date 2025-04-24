package com.example.DRbackend.repository;


import com.example.DRbackend.model.EmergencyRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmergencyRepository extends MongoRepository<EmergencyRequest, String> {
}