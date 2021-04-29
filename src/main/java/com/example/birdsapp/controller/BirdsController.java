package com.example.birdsapp.controller;

import com.example.birdsapp.dto.BirdDto;
import com.example.birdsapp.exceptions.ElementAlreadyExistsException;
import com.example.birdsapp.exceptions.NoSuchElementException;
import com.example.birdsapp.service.api.BirdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/birds")
@RequiredArgsConstructor
public class BirdsController {
    private final BirdsService birdsService;

    @GetMapping
    public List<BirdDto> findAll() {
        return birdsService.findAll();
    }

    @GetMapping("/nests/{nestId}")
    public List<BirdDto> findAllBirdsOfTheNest(@PathVariable Long nestId) {
        return birdsService.findAllByNestId(nestId);
    }

    @GetMapping("/{id}")
    public BirdDto getBirdByID(@PathVariable Long id) throws NoSuchElementException {
        return birdsService.readById(id);
    }

    @PostMapping
    public BirdDto addNewBird(@RequestBody BirdDto birdDto) throws ElementAlreadyExistsException, NoSuchElementException {
        return birdsService.create(birdDto);
    }

    @PutMapping()
    public BirdDto updateExistingBird(@RequestBody BirdDto birdDto) throws NoSuchElementException {
        return birdsService.update(birdDto);
    }

    @DeleteMapping("/{id}")
    public BirdDto deleteBirdById(@PathVariable Long id) throws NoSuchElementException {
        return birdsService.deleteById(id);
    }
}
