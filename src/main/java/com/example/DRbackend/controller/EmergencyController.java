package com.example.DRbackend.controller;


import com.example.DRbackend.DTO.RequestDTO;
import com.example.DRbackend.entity.Request;
import com.example.DRbackend.model.EmergencyRequest;
import com.example.DRbackend.repository.EmergencyRepository;
import com.example.DRbackend.repository.RequestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/request")
@CrossOrigin(origins = "*") // Allow frontend to access API
public class EmergencyController {
    private final RequestRepository repository;

    public EmergencyController(RequestRepository repository) {
        this.repository = repository;
    }

    // Fetch all emergency requests
    @GetMapping
    public List<Request> getAllRequests() {
        // Only return requests with a status of "Pending"
        return repository.findByStatus("Pending");
    }

    // Fetch a single emergency request by ID
    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable String id) {
        Optional<Request> request = repository.findById(id);
        return request.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new emergency request
    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        System.out.println("Received Request: " + request);
        request.setStatus("Pending"); // Default status
        return repository.save(request);
    }

    // Update the status of an emergency request
    @PutMapping("/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable String id, @RequestBody Request updatedRequest) {
        return repository.findById(id)
                .map(existingRequest -> {
                    existingRequest.setStatus(updatedRequest.getStatus());
                    existingRequest.setHelpType(updatedRequest.getHelpType());
                    existingRequest.setContactNumber(updatedRequest.getContactNumber());
                    repository.save(existingRequest);
                    return ResponseEntity.ok(existingRequest);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an emergency request
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Accept an emergency request (change its status to "Accepted")
    @PutMapping("/{id}/accept")
    public ResponseEntity<Request> acceptRequest(@PathVariable String id) {
        Optional<Request> requestOptional = repository.findById(id);

        if (requestOptional.isPresent()) {
            Request request = requestOptional.get();
            request.setStatus("Accepted");  // Change the status to Accepted
            repository.save(request);  // Save the updated request

            return ResponseEntity.ok(request);  // Return the updated request
        }

        return ResponseEntity.notFound().build();  // If request not found, return 404
    }

    // Get all accepted requests
    @GetMapping("/accepted")
    public ResponseEntity<List<Request>> getAcceptedRequests() {
        List<Request> acceptedRequests = repository.findByStatus("Accepted");
        return ResponseEntity.ok(acceptedRequests);
    }
}
