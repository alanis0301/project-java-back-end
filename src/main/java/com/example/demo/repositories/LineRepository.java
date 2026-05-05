package com.example.demo.repositories;

import com.example.demo.dtos.LineDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<LineDTO, Integer> {
}