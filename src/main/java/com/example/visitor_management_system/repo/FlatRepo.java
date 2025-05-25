package com.example.visitor_management_system.repo;

import com.example.visitor_management_system.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepo extends JpaRepository<Flat, Long> {

    public Flat findFlatByNumber(String number);
}
