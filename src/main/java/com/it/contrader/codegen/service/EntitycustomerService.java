package com.it.contrader.codegen.service;

import com.it.contrader.codegen.service.dto.EntitycustomerDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Entitycustomer.
 */
public interface EntitycustomerService {

    /**
     * Save a entitycustomer.
     *
     * @param entitycustomerDTO the entity to save
     * @return the persisted entity
     */
    EntitycustomerDTO save(EntitycustomerDTO entitycustomerDTO);

    /**
     * Get all the entitycustomers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<EntitycustomerDTO> findAll(Pageable pageable);


    /**
     * Get the "id" entitycustomer.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<EntitycustomerDTO> findOne(Long id);

    /**
     * Delete the "id" entitycustomer.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
