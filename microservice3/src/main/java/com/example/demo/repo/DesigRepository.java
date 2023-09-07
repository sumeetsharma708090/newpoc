package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Designation;

@Repository
public interface DesigRepository extends JpaRepository<Designation, Integer>{

}
