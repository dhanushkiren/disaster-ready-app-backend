package com.example.DRbackend.service;

import com.example.DRbackend.DTO.RequestDTO;
import com.example.DRbackend.entity.Request;
import com.example.DRbackend.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<RequestDTO> getAllRequests() {
        return requestRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RequestDTO saveRequest(RequestDTO requestDTO) {
        Request request = new Request();
        request.setName(requestDTO.getName());
        request.setContactNumber(requestDTO.getContactNumber());
        request.setHelpType(requestDTO.getHelpType());
        request.setLandmark(requestDTO.getLandmark());

        if (requestDTO.getExactLocation() != null) {
            request.setExactLocation(requestDTO.getExactLocation()); // Directly set the map
        }

        Request savedRequest = requestRepository.save(request);
        return convertToDTO(savedRequest);
    }

    private RequestDTO convertToDTO(Request request) {
        RequestDTO dto = new RequestDTO();
        dto.setId(request.getId());
        dto.setName(request.getName());
        dto.setContactNumber(request.getContactNumber());
        dto.setHelpType(request.getHelpType());
        dto.setLandmark(request.getLandmark());

        if (request.getExactLocation() != null) {
            dto.setExactLocation(request.getExactLocation()); // Directly set the map
        }

        return dto;
    }

    public void deleteRequest(String id) {
        requestRepository.deleteById(id);
    }


}