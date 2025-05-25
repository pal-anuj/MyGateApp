package com.example.visitor_management_system.entity;

import com.example.visitor_management_system.enums.Role;
import com.example.visitor_management_system.enums.UserStatus;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role roleId; //Admin,

    @ManyToOne(fetch = FetchType.LAZY)
    private Flat flat;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Address address;

    @Enumerated(EnumType.STRING)
    private UserStatus Status;//Active or Inactive

    @CreationTimestamp
    private Date createdTimeStamp;

    @UpdateTimestamp
    private Date updatedTimeStamp;
}
