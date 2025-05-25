package com.example.visitor_management_system.util;

import com.example.visitor_management_system.dto.AddressDTO;
import com.example.visitor_management_system.entity.Address;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

    public Address convertAddressDTO(AddressDTO addressDTO){
        Address address = Address.builder()
                .line1(addressDTO.getLine1())
                .line2(addressDTO.getLine2())
                .city(addressDTO.getCity())
                .pincode(addressDTO.getPincode())
                .build();
        return address;
    }

}
