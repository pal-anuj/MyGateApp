package com.example.visitor_management_system.services;

import com.example.visitor_management_system.dto.VisitDTO;
import com.example.visitor_management_system.entity.Flat;
import com.example.visitor_management_system.entity.User;
import com.example.visitor_management_system.entity.Visit;
import com.example.visitor_management_system.entity.Visitor;
import com.example.visitor_management_system.enums.VisitStatus;
import com.example.visitor_management_system.exception.BadRequestException;
import com.example.visitor_management_system.exception.NotFoundException;
import com.example.visitor_management_system.repo.FlatRepo;
import com.example.visitor_management_system.repo.UserRepo;
import com.example.visitor_management_system.repo.VisitRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResidentService {

    @Autowired
    private VisitRepo visitRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FlatRepo flatRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResidentService.class);

    public String updateVisit(Long id, VisitStatus visitStatus) {

        LOGGER.info("VisitId: {} and VisitStatus: {}",id,visitStatus);

        if(visitStatus != VisitStatus.REJECTED && visitStatus!=VisitStatus.APPROVED){
            throw new BadRequestException("Invalid state transition");
        }
        Visit visit = visitRepo.findById(id).get();
        if(visit ==null){
            throw new NotFoundException("Visit not found");
        }
        if(VisitStatus.WAITING.equals(visit.getVisitStatus())){
            visit.setVisitStatus(visitStatus);
            visitRepo.save(visit);
        }
        else{
            throw new BadRequestException("Invalid state transition");
        }
        return "Done: updateVisit";
    }

    public List<VisitDTO> getpendingVisits(Long userId) {
         User user = userRepo.findById(userId).get();
         Flat flat = user.getFlat();
        //flatRepo.findFlatByNumber(user.getFlat().getNumber());

        List<Visit> visitList = visitRepo.findByVisitStatusAndFlat(VisitStatus.WAITING, flat);
        List<VisitDTO> visitDTOList = new ArrayList<>();

        for(Visit visit : visitList){
            Visitor visitor = visit.getVisitor();
            VisitDTO visitDTO = VisitDTO.builder()
                    .flatNumber(flat.getNumber())
                    .purpose(visit.getPurpose())
                    .imageUrl(visit.getImageUrl())
                    .noOfPeople(visit.getNoOfPeople())
                    .visitorName(visitor.getName())
                    .visitorEmail(visitor.getEmail())
                    .phone(visitor.getPhone())
                    .visitStatus(VisitStatus.WAITING)
                    .build();

            visitDTOList.add(visitDTO);
        }
        return visitDTOList;
    }
}
