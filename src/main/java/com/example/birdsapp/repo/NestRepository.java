package com.example.birdsapp.repo;

import com.example.birdsapp.model.NestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestRepository extends JpaRepository<NestEntity, Long> {
}
