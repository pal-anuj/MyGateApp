package com.example.visitor_management_system.dto;

import com.example.visitor_management_system.entity.Flat;
import com.example.visitor_management_system.entity.Visitor;
import com.example.visitor_management_system.enums.VisitStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class VisitDTO {

    @NotNull
    private VisitStatus visitStatus;

    @NotNull
    @Max(255)
    private String purpose;

    @NotNull
    private String imageUrl;

    @NotNull
    private Integer noOfPeople;

    @NotNull
    private Visitor visitor;

    private Flat flat;

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
