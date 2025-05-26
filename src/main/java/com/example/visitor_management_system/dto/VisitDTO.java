package com.example.visitor_management_system.dto;

import com.example.visitor_management_system.entity.Flat;
import com.example.visitor_management_system.entity.Visitor;
import com.example.visitor_management_system.enums.VisitStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisitDTO {

    @NotNull
    private VisitStatus visitStatus;
    private Date inTime;
    private Date outTime;

    @NotNull
    @Max(255)
    private String purpose;

    @NotNull
    private String imageUrl;

    @NotNull
    private Integer noOfPeople;

    @NotNull
    private String flatNumber;

    @NotNull
    @Max(255)
    private String visitorName;

    @NotNull
    @Max(255)
    private String visitorEmail;

    @NotNull
    @Min(10)
    @Max(10)
    private String phone;
}
