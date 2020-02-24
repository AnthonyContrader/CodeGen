package com.it.contrader.codegen.service.impl;

import com.it.contrader.codegen.service.EntityownerService;
import com.it.contrader.codegen.domain.Entityowner;
import com.it.contrader.codegen.repository.EntityownerRepository;
import com.it.contrader.codegen.service.dto.EntityownerDTO;
import com.it.contrader.codegen.service.mapper.EntityownerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Entityowner.
 */
@Service
@Transactional
public class EntityownerServiceImpl implements EntityownerService {

    private final Logger log = LoggerFactory.getLogger(EntityownerServiceImpl.class);

    private final EntityownerRepository entityownerRepository;

    private final EntityownerMapper entityownerMapper;

    public EntityownerServiceImpl(EntityownerRepository entityownerRepository, EntityownerMapper entityownerMapper) {
        this.entityownerRepository = entityownerRepository;
        this.entityownerMapper = entityownerMapper;
    }

    /**
     * Save a entityowner.
     *
     * @param entityownerDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public EntityownerDTO save(EntityownerDTO entityownerDTO) {
        log.debug("Request to save Entityowner : {}", entityownerDTO);
        Entityowner entityowner = entityownerMapper.toEntity(entityownerDTO);
        entityowner = entityownerRepository.save(entityowner);
        return entityownerMapper.toDto(entityowner);
    }

    /**
     * Get all the entityowners.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<EntityownerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Entityowners");
        return entityownerRepository.findAll(pageable)
            .map(entityownerMapper::toDto);
    }


    /**
     * Get one entityowner by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<EntityownerDTO> findOne(Long id) {
        log.debug("Request to get Entityowner : {}", id);
        return entityownerRepository.findById(id)
            .map(entityownerMapper::toDto);
    }

    /**
     * Delete the entityowner by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Entityowner : {}", id);
        entityownerRepository.deleteById(id);
    }
}
