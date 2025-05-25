package com.example.visitor_management_system.entity;

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
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;  //this will be our Id Number

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Address address;

    @CreationTimestamp
    private Date createdTimeStamp;

    @UpdateTimestamp
    private Date updatedTimeStamp;

}
