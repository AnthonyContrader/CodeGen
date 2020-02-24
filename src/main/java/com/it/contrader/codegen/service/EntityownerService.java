package com.it.contrader.codegen.service;

import com.it.contrader.codegen.service.dto.EntityownerDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Entityowner.
 */
public interface EntityownerService {

    /**
     * Save a entityowner.
     *
     * @param entityownerDTO the entity to save
     * @return the persisted entity
     */
    EntityownerDTO save(EntityownerDTO entityownerDTO);

    /**
     * Get all the entityowners.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<EntityownerDTO> findAll(Pageable pageable);


    /**
     * Get the "id" entityowner.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<EntityownerDTO> findOne(Long id);

    /**
     * Delete the "id" entityowner.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
