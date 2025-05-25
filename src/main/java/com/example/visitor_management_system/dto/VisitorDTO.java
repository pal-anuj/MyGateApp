package com.example.visitor_management_system.dto;

import com.example.visitor_management_system.entity.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitorDTO {

    @NotNull
    @Max(255)
    private String name;

    @NotNull
    @Max(255)
    private String email;

    @NotNull
    @Min(10)
    @Max(10)
    private String phone;

    private AddressDTO addressDTO;

}
