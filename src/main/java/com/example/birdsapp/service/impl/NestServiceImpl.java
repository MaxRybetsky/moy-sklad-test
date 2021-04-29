package com.example.birdsapp.service.impl;

import com.example.birdsapp.dto.NestDto;
import com.example.birdsapp.exceptions.ElementAlreadyExistsException;
import com.example.birdsapp.exceptions.NoSuchElementException;
import com.example.birdsapp.model.NestEntity;
import com.example.birdsapp.repo.NestRepository;
import com.example.birdsapp.service.api.NestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NestServiceImpl implements NestService {
    private final NestRepository nestRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<NestDto> findAll() {
        List<NestEntity> nestEntities = nestRepository.findAll();
        return modelMapper.map(nestEntities, new TypeToken<List<NestDto>>() {
        }.getType());
    }

    @Override
    @Transactional
    public NestDto create(NestDto elem) throws ElementAlreadyExistsException {
        Long id = elem.getId();
        if (id != null && nestRepository.findById(id).isPresent()) {
            throw new ElementAlreadyExistsException(String.format("Nest with id=%d already exists!", id));
        }
        NestEntity nestEntity = modelMapper.map(elem, NestEntity.class);
        nestRepository.save(nestEntity);
        return modelMapper.map(nestEntity, NestDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public NestDto readById(Long id) throws NoSuchElementException {
        NestEntity nestEntity = findNestEntityById(id);
        return modelMapper.map(nestEntity, NestDto.class);
    }

    @Override
    @Transactional
    public NestDto update(NestDto elem) throws NoSuchElementException {
        findNestEntityById(elem.getId());
        NestEntity nestEntity = modelMapper.map(elem, NestEntity.class);
        nestRepository.save(nestEntity);
        return elem;
    }

    @Override
    @Transactional
    public NestDto deleteById(Long id) throws NoSuchElementException {
        NestDto deletedElem = readById(id);
        nestRepository.deleteById(id);
        return deletedElem;
    }

    private NestEntity findNestEntityById(Long id) throws NoSuchElementException {
        return nestRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(String.format("There is no nest with id=%d", id))
        );
    }
}
