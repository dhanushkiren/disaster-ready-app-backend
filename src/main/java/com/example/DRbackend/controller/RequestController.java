package com.example.DRbackend.controller;

import com.example.DRbackend.DTO.RequestDTO;
import com.example.DRbackend.entity.Request;
import com.example.DRbackend.repository.RequestRepository;
import com.example.DRbackend.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;
    private RequestRepository requestRepository;
    @Autowired
    public RequestController(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @GetMapping
    public List<RequestDTO> getAllRequests() {
        return requestService.getAllRequests();
    }

    @PostMapping
    public RequestDTO saveRequest(@RequestBody RequestDTO requestDTO) {
        return requestService.saveRequest(requestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmergency(@PathVariable String id) {
        Optional<Request> request = requestRepository.findById(id);
        if (request.isPresent()) {
            requestRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
