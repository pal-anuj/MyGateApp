package com.example.visitor_management_system.controller;

import com.example.visitor_management_system.dto.UserDTO;
import com.example.visitor_management_system.entity.User;
import com.example.visitor_management_system.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/createUser")
    public ResponseEntity<Long> createUser(@RequestBody @Valid UserDTO userDTO){
        Long id = adminService.createUser(userDTO);
        return ResponseEntity.ok(id);
    }


}
