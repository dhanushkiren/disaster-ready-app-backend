package com.example.DRbackend.controller;

import com.example.DRbackend.DTO.MessageDTO;
import com.example.DRbackend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<MessageDTO> getAllMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping
    public MessageDTO saveMessage(@RequestBody MessageDTO messageDTO) {
        return messageService.saveMessage(messageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable String id) { // Changed Long to String
        messageService.deleteMessage(id);
    }
}
