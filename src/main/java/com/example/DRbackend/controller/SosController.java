package com.example.DRbackend.controller;

import com.example.DRbackend.DTO.SosRequestDto;
import com.example.DRbackend.model.SosDetails;
import com.example.DRbackend.service.SosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sos")
@CrossOrigin
public class SosController {

    @Autowired
    private SosService sosService;

    @PostMapping
    public ResponseEntity<SosDetails> sendSOS(@RequestBody SosRequestDto request) {
        SosDetails response = sosService.sendSOS(request);
        return ResponseEntity.ok(response); // Ensures JSON response
    }
}