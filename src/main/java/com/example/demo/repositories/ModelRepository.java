package com.example.demo.repositories;

import com.example.demo.dtos.ModelDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelDTO, Integer> {

}