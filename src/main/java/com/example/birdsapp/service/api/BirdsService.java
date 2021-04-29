package com.example.birdsapp.service.api;

import com.example.birdsapp.dto.BirdDto;

import java.util.List;

/**
 * Service for working with Birds
 */
public interface BirdsService extends BaseCrudService<BirdDto> {
    /**
     * Returns Birds of Nest with specifying ID.
     *
     * @param nestId Nest Id.
     * @return List of birds of the nest.
     */
    List<BirdDto> findAllByNestId(Long nestId);
}
