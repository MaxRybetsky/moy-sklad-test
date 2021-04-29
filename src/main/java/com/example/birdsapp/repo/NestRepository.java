package com.example.birdsapp.repo;

import com.example.birdsapp.model.Nest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestRepository extends JpaRepository<Nest, Long> {
}
