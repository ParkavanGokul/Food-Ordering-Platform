package com.jsd.basicfoodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsd.basicfoodorder.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
