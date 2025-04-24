package com.example.DRbackend.model;

import java.time.LocalDateTime;

public class SosDetails {
    private String phoneNumber;
    private LocalDateTime triggeredAt;

    public SosDetails(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.triggeredAt = LocalDateTime.now();
    }

}