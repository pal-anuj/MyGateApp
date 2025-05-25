package com.example.visitor_management_system.entity;

import com.example.visitor_management_system.enums.UserStatus;
import com.example.visitor_management_system.enums.VisitStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private VisitStatus visitStatus;

    @Column(nullable = false)
    private String purpose;

    private Date inTime;

    private Date outTime;

    private String imageUrl;

    @Column(nullable = false)
    private Integer noOfPeople;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="visitor_Id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name="flat_Id")
    private Flat flat;

    @CreationTimestamp
    private Date createdTimeStamp;

    @UpdateTimestamp
    private Date updatedTimeStamp;

}
