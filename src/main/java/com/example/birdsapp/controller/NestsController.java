package com.example.birdsapp.controller;

import com.example.birdsapp.dto.NestDto;
import com.example.birdsapp.exceptions.ElementAlreadyExistsException;
import com.example.birdsapp.exceptions.NoSuchElementException;
import com.example.birdsapp.service.api.NestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nests")
@RequiredArgsConstructor
public class NestsController {
    private final NestService nestService;

    @GetMapping
    public List<NestDto> findAll() {
        return nestService.findAll();
    }

    @GetMapping("/{id}")
    public NestDto getNestByID(@PathVariable Long id) throws NoSuchElementException {
        return nestService.readById(id);
    }

    @PostMapping
    public NestDto addNewNest(@RequestBody NestDto nestDto) throws ElementAlreadyExistsException, NoSuchElementException {
        return nestService.create(nestDto);
    }

    @PutMapping()
    public NestDto updateExistingNest(@RequestBody NestDto nestDto) throws NoSuchElementException {
        return nestService.update(nestDto);
    }

    @DeleteMapping("/{id}")
    public NestDto deleteNestById(@PathVariable Long id) throws NoSuchElementException {
        return nestService.deleteById(id);
    }
}
