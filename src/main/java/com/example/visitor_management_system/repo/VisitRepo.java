package com.example.visitor_management_system.repo;

import com.example.visitor_management_system.entity.Flat;
import com.example.visitor_management_system.entity.Visit;
import com.example.visitor_management_system.enums.VisitStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepo extends JpaRepository<Visit, Long> {

    List<Visit> findByVisitStatusAndFlat(VisitStatus visitStatus, Flat flat);
}
