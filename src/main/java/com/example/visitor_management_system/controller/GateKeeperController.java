package com.example.visitor_management_system.controller;

import com.example.visitor_management_system.dto.VisitDTO;
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

    @GetMapping("/getVisitorById")
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

    @PostMapping("/createVisit")
    public ResponseEntity<Long> createVisit(@RequestBody VisitDTO visitDTO){
        Long id = gateKeeperService.createVisit(visitDTO);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/markEntry/{visitId}")
    public ResponseEntity<String> markEntry(@PathVariable Long visitId){
            String msg = gateKeeperService.markEntry(visitId);
            return ResponseEntity.ok(msg);
    }

    @PutMapping("/markExit/{visitId}")
    public ResponseEntity<String> markExit(@PathVariable Long visitId){
            String msg = gateKeeperService.markExit(visitId);
            return ResponseEntity.ok(msg);
    }
}
