package com.example.visitor_management_system.services;

import com.example.visitor_management_system.dto.AddressDTO;
import com.example.visitor_management_system.dto.VisitDTO;
import com.example.visitor_management_system.dto.VisitorDTO;
import com.example.visitor_management_system.entity.Address;
import com.example.visitor_management_system.entity.Flat;
import com.example.visitor_management_system.entity.Visit;
import com.example.visitor_management_system.entity.Visitor;
import com.example.visitor_management_system.enums.VisitStatus;
import com.example.visitor_management_system.exception.BadRequestException;
import com.example.visitor_management_system.exception.NotFoundException;
import com.example.visitor_management_system.repo.FlatRepo;
import com.example.visitor_management_system.repo.VisitRepo;
import com.example.visitor_management_system.repo.VisitorRepo;
import com.example.visitor_management_system.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class GateKeeperService {

    @Autowired
    private VisitorRepo visitorRepo;

    @Autowired
    private CommonUtil commonUtil;

    @Autowired
    private FlatRepo flatRepo;

    @Autowired
    private VisitRepo visitRepo;


    public VisitorDTO getVisitorById(String phone)
    {

        Visitor visitor = visitorRepo.findVisitorByPhone(phone);
        VisitorDTO visitorDTO =null;
        if(visitor !=null){
            Address address = visitor.getAddress();
            AddressDTO addressDTO = AddressDTO.builder()
                    .line1(address.getLine1())
                    .line2(address.getLine2())
                    .city(address.getCity())
                    .pincode(address.getPincode())
                    .build();

            visitorDTO = VisitorDTO.builder()
                    .name(visitor.getName())
                    .email(visitor.getEmail())
                    .phone(visitor.getPhone())
                    .addressDTO(addressDTO)
                    .build();
        }
        return visitorDTO;
    }

    public Long createVisitor(VisitorDTO visitorDTO) {


        AddressDTO addressDTO = visitorDTO.getAddressDTO();
        Address address = commonUtil.convertAddressDTO(addressDTO);

        Visitor visitor = Visitor.builder()
                .name(visitorDTO.getName())
                .email(visitorDTO.getEmail())
                .phone(visitorDTO.getPhone())
                .address(address)
                .build();

        visitor = visitorRepo.save(visitor);
        return visitor.getId();
    }

    public Long createVisit(VisitDTO visitDTO) {

        Flat flat = flatRepo.findFlatByNumber(visitDTO.getFlatNumber());
        Visitor visitor = visitorRepo.findVisitorByPhone(visitDTO.getPhone());

        Visit visit = Visit.builder()
                .flat(flat)
                .purpose(visitDTO.getPurpose())
                .imageUrl(visitDTO.getImageUrl())
                .noOfPeople(visitDTO.getNoOfPeople())
                .visitor(visitor)
                .visitStatus(VisitStatus.WAITING)
                .build();

        visit = visitRepo.save(visit);
        return visit.getId();

    }

    public String markEntry(Long id){

        Visit visit = visitRepo.findById(id).get();

        if(visit==null) {
            //will add some exception
            throw new NotFoundException("Given VisitId is not found");
        }
        if(visit.getVisitStatus().equals(VisitStatus.APPROVED)){
            visit.setInTime(new Date());
            visitRepo.save(visit);
        }else {
            throw new BadRequestException("VisitID: {}, have invalid status - not in Approved status");
        }
        return "In Time update success";
    }

    @Transactional
    public String markExit(Long id) {
        Visit visit = visitRepo.findById(id).get();

        if(visit==null) {
            //will add some exception
            throw new NotFoundException("Given VisitId is not found");
        }
        if(visit.getVisitStatus().equals(VisitStatus.APPROVED) && visit.getInTime()!=null){
            visit.setOutTime(new Date());
            visit.setVisitStatus(VisitStatus.COMPLETED);
           // visit = visitRepo.save(visit);
        }else {
            throw new BadRequestException("VisitID: {}, have invalid status - not in Approved status");
        }
        return "Out Time update success";
    }
}
