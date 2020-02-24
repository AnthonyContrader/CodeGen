package com.it.contrader.codegen.service.impl;

import com.it.contrader.codegen.service.EntitycustomerService;
import com.it.contrader.codegen.domain.Entitycustomer;
import com.it.contrader.codegen.repository.EntitycustomerRepository;
import com.it.contrader.codegen.service.dto.EntitycustomerDTO;
import com.it.contrader.codegen.service.mapper.EntitycustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Entitycustomer.
 */
@Service
@Transactional
public class EntitycustomerServiceImpl implements EntitycustomerService {

    private final Logger log = LoggerFactory.getLogger(EntitycustomerServiceImpl.class);

    private final EntitycustomerRepository entitycustomerRepository;

    private final EntitycustomerMapper entitycustomerMapper;

    public EntitycustomerServiceImpl(EntitycustomerRepository entitycustomerRepository, EntitycustomerMapper entitycustomerMapper) {
        this.entitycustomerRepository = entitycustomerRepository;
        this.entitycustomerMapper = entitycustomerMapper;
    }

    /**
     * Save a entitycustomer.
     *
     * @param entitycustomerDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public EntitycustomerDTO save(EntitycustomerDTO entitycustomerDTO) {
        log.debug("Request to save Entitycustomer : {}", entitycustomerDTO);
        Entitycustomer entitycustomer = entitycustomerMapper.toEntity(entitycustomerDTO);
        entitycustomer = entitycustomerRepository.save(entitycustomer);
        return entitycustomerMapper.toDto(entitycustomer);
    }

    /**
     * Get all the entitycustomers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<EntitycustomerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Entitycustomers");
        return entitycustomerRepository.findAll(pageable)
            .map(entitycustomerMapper::toDto);
    }


    /**
     * Get one entitycustomer by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<EntitycustomerDTO> findOne(Long id) {
        log.debug("Request to get Entitycustomer : {}", id);
        return entitycustomerRepository.findById(id)
            .map(entitycustomerMapper::toDto);
    }

    /**
     * Delete the entitycustomer by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Entitycustomer : {}", id);
        entitycustomerRepository.deleteById(id);
    }
}
