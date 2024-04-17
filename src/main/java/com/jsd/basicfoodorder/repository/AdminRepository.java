package com.jsd.basicfoodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsd.basicfoodorder.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
