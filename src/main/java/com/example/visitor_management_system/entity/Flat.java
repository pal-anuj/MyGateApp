package com.example.visitor_management_system.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    @OneToMany(mappedBy = "flat")
    private Set<User> userSet;

    private String owner;

    @CreationTimestamp
    private Date createdTimeStamp;

    @UpdateTimestamp
    private Date updatedTimeStamp;
}
