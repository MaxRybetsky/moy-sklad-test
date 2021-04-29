package com.example.birdsapp.repo;

import com.example.birdsapp.model.BirdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdsRepository extends JpaRepository<BirdEntity, Long> {
}
