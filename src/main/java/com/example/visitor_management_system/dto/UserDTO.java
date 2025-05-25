package com.example.visitor_management_system.dto;


import com.example.visitor_management_system.entity.Address;
import com.example.visitor_management_system.enums.Role;
import lombok.*;
import jakarta.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 10)
    private String phone;

    private Role role;
    private String flatNo;
    private AddressDTO address;

}
