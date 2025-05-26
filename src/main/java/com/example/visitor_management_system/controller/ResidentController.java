package com.example.visitor_management_system.controller;

import com.example.visitor_management_system.dto.VisitDTO;
import com.example.visitor_management_system.enums.VisitStatus;
import com.example.visitor_management_system.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resident")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @PutMapping("/actionOnVisit/{visitId}")
    public ResponseEntity<String>  actionOnVisit(@PathVariable Long visitId, @RequestParam VisitStatus visitStatus){
        return ResponseEntity.ok(residentService.updateVisit(visitId, visitStatus));
    }

    @GetMapping("/pendingVisits")
    public ResponseEntity<List<VisitDTO>> getpendingVisits(@RequestHeader Long userId){
        List<VisitDTO> visitDTOList = residentService.getpendingVisits(userId);
        return ResponseEntity.ok(visitDTOList);
    }
}
