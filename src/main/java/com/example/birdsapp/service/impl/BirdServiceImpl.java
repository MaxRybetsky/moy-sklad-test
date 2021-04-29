package com.example.birdsapp.service.impl;

import com.example.birdsapp.dto.BirdDto;
import com.example.birdsapp.dto.NestDto;
import com.example.birdsapp.exceptions.ElementAlreadyExistsException;
import com.example.birdsapp.exceptions.NoSuchElementException;
import com.example.birdsapp.model.BirdEntity;
import com.example.birdsapp.model.NestEntity;
import com.example.birdsapp.repo.BirdsRepository;
import com.example.birdsapp.service.api.BirdsService;
import com.example.birdsapp.service.api.NestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BirdServiceImpl implements BirdsService {
    private final BirdsRepository birdsRepository;
    private final NestService nestService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<BirdDto> findAll() {
        List<BirdEntity> birdEntities = birdsRepository.findAll();
        return modelMapper.map(birdEntities, new TypeToken<List<BirdDto>>() {
        }.getType());
    }

    @Override
    @Transactional
    public BirdDto create(BirdDto elem) throws ElementAlreadyExistsException, NoSuchElementException {
        Long id = elem.getId();
        if (id != null && birdsRepository.findById(id).isPresent()) {
            throw new ElementAlreadyExistsException(String.format("Bird with id=%d already exists!", id));
        }
        BirdEntity birdEntity = modelMapper.map(elem, BirdEntity.class);
        addNestFromDtoToEntity(birdEntity, elem);
        birdsRepository.save(birdEntity);
        return modelMapper.map(birdEntity, BirdDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public BirdDto readById(Long id) throws NoSuchElementException {
        BirdEntity birdEntity = findBirdEntityById(id);
        return modelMapper.map(birdEntity, BirdDto.class);
    }

    @Override
    @Transactional
    public BirdDto update(BirdDto elem) throws NoSuchElementException {
        findBirdEntityById(elem.getId());
        BirdEntity birdEntity = modelMapper.map(elem, BirdEntity.class);
        addNestFromDtoToEntity(birdEntity, elem);
        birdsRepository.save(birdEntity);
        return elem;
    }

    @Override
    @Transactional
    public BirdDto deleteById(Long id) throws NoSuchElementException {
        BirdDto deletedElem = readById(id);
        birdsRepository.deleteById(id);
        return deletedElem;
    }

    private BirdEntity findBirdEntityById(Long id) throws NoSuchElementException {
        return birdsRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(String.format("There is no bird with id=%d", id))
        );
    }

    private void addNestFromDtoToEntity(BirdEntity birdEntity, BirdDto birdDto) throws NoSuchElementException {
        Long nestId = birdDto.getNest().getId();
        if (nestId != null) {
            NestDto nestDto = nestService.readById(nestId);
            NestEntity nestEntity = modelMapper.map(nestDto, NestEntity.class);
            birdEntity.setNest(nestEntity);
        }
    }
}
