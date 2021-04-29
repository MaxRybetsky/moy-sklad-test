package com.example.birdsapp.service.api;

import com.example.birdsapp.exceptions.ElementAlreadyExistsException;
import com.example.birdsapp.exceptions.NoSuchElementException;

import java.util.List;

/**
 * Base CRUD Service.
 *
 * @param <T> Custom DTO
 */
public interface BaseCrudService<T> {
    /**
     * Returns all elements from storage.
     *
     * @return List of elements.
     */
    List<T> findAll();

    /**
     * Adds element to storage.
     *
     * @param elem Element to add.
     * @return Element with updated ID parameters.
     * @throws ElementAlreadyExistsException If such element already exists.
     * @throws NoSuchElementException If some related items were not found.
     */
    T create(T elem) throws ElementAlreadyExistsException, NoSuchElementException;

    /**
     * Reads element from storage by its ID.
     *
     * @param id Id of element.
     * @return Element with specifying ID if presents.
     * @throws NoSuchElementException If there is no such element in storage.
     */
    T readById(Long id) throws NoSuchElementException;

    /**
     * Updates element with new data.
     *
     * @param elem Element with new data.
     * @return Updated element.
     * @throws NoSuchElementException If there is no such element in storage.
     */
    T update(T elem) throws NoSuchElementException;

    /**
     * Deletes element from storage by its ID.
     *
     * @param id ID of element to delete.
     * @return Deleted element.
     * @throws NoSuchElementException If there is no such element in storage.
     */
    T deleteById(Long id) throws NoSuchElementException;
}
