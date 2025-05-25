package com.example.visitor_management_system.services;

import com.example.visitor_management_system.dto.AddressDTO;
import com.example.visitor_management_system.dto.UserDTO;
import com.example.visitor_management_system.entity.Address;
import com.example.visitor_management_system.entity.Flat;
import com.example.visitor_management_system.entity.User;
import com.example.visitor_management_system.enums.UserStatus;
import com.example.visitor_management_system.repo.FlatRepo;
import com.example.visitor_management_system.repo.UserRepo;
import com.example.visitor_management_system.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FlatRepo flatRepo;

    @Autowired
    private CommonUtil commonUtil;

    public Long createUser(UserDTO userDTO) {

        AddressDTO addressDTO = userDTO.getAddress();
        Address address = commonUtil.convertAddressDTO(addressDTO);

        Flat flat = null;
        if(userDTO.getFlatNo() !=null){
            flat = flatRepo.findFlatByNumber(userDTO.getFlatNo());
        }

        User user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .roleId(userDTO.getRole())
                .phone(userDTO.getPhone())
                .address(address)
                .flat(flat)
                .Status(UserStatus.ACTIVE)
                .build();

        user = userRepo.save(user);
        return user.getId();
    }
}
