package com.example.DRbackend.service;

import com.example.DRbackend.DTO.MessageDTO;
import com.example.DRbackend.entity.Message;
import com.example.DRbackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageDTO> getAllMessages() {
        return messageRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MessageDTO saveMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setText(messageDTO.getText());
        message.setUser(messageDTO.getUser());
        message.setEditable(messageDTO.isEditable());

        Message savedMessage = messageRepository.save(message);
        return convertToDTO(savedMessage);
    }

    public void deleteMessage(String id) { // Changed Long to String
        messageRepository.deleteById(id);
    }

    private MessageDTO convertToDTO(Message message) {
        MessageDTO dto = new MessageDTO();
        dto.setId(message.getId()); // Now a String
        dto.setText(message.getText());
        dto.setUser(message.getUser());
        dto.setTimestamp(message.getTimestamp());
        dto.setEditable(message.isEditable());
        return dto;
    }
}
