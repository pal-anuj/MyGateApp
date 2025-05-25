package com.example.visitor_management_system.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    private String line1;
    private String line2;
    private String city;
    private String pincode;
}
