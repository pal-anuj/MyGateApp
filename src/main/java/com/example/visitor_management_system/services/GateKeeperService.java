package com.example.visitor_management_system.services;

import com.example.visitor_management_system.dto.AddressDTO;
import com.example.visitor_management_system.dto.VisitorDTO;
import com.example.visitor_management_system.entity.Address;
import com.example.visitor_management_system.entity.Visitor;
import com.example.visitor_management_system.repo.VisitorRepo;
import com.example.visitor_management_system.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GateKeeperService {

    @Autowired
    private VisitorRepo visitorRepo;

    @Autowired
    private CommonUtil commonUtil;

    public VisitorDTO getVisitorById(String phone)
    {
        Visitor visitor = visitorRepo.findVisitorByPhone(phone);
        VisitorDTO visitorDTO = null;
        if(visitor !=null){
            visitorDTO = VisitorDTO.builder()
                    .name(visitor.getName())
                    .email(visitor.getEmail())
                    .phone(visitor.getPhone())
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
}
