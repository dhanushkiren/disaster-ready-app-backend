package com.example.DRbackend.service;


import com.example.DRbackend.DTO.SosRequestDto;
import com.example.DRbackend.model.SosDetails;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class SosService {

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    public SosDetails sendSOS(SosRequestDto request) {
        PhoneNumber to = new PhoneNumber(request.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(fromPhoneNumber);

        Call.creator(
                to,
                from,
                URI.create("https://handler.twilio.com/twiml/EHd0b9d9ef88d51239a5c13555e7102603") // Or custom hosted TwiML
        ).create();

        return new SosDetails(request.getPhoneNumber());
    }
}
