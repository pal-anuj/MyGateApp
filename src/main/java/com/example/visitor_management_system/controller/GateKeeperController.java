package com.example.visitor_management_system.controller;

import com.example.visitor_management_system.dto.VisitorDTO;
import com.example.visitor_management_system.services.GateKeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gatekeeper")
public class GateKeeperController {

    @Autowired
    private GateKeeperService gateKeeperService;

    @GetMapping
    public ResponseEntity<VisitorDTO> getVisitorById(@RequestParam String phone){
        VisitorDTO visitorDTO = gateKeeperService.getVisitorById(phone);
        if(visitorDTO ==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(visitorDTO);
    }

    @PostMapping("/createVisitor")
    public ResponseEntity<Long> createVisitor(@RequestBody VisitorDTO visitorDTO){
        Long id = gateKeeperService.createVisitor(visitorDTO);
        return ResponseEntity.ok(id);
    }

//    @PostMapping("/createVisit")
//    Public Response<>

}
