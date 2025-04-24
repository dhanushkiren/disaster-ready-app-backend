package com.example.DRbackend.controller;

import com.example.DRbackend.DTO.UserDTO;
import com.example.DRbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.registerUser(userDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.loginUser(userDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
