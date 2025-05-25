package com.example.visitor_management_system.repo;


import com.example.visitor_management_system.entity.Visitor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VisitorRepo extends JpaRepository<Visitor, Long> {

    Visitor findVisitorByPhone(String phone);

}
