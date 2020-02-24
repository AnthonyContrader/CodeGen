package com.it.contrader.codegen.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.it.contrader.codegen.service.EntitycustomerService;
import com.it.contrader.codegen.web.rest.errors.BadRequestAlertException;
import com.it.contrader.codegen.web.rest.util.HeaderUtil;
import com.it.contrader.codegen.web.rest.util.PaginationUtil;
import com.it.contrader.codegen.service.dto.EntitycustomerDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Entitycustomer.
 */
@RestController
@RequestMapping("/api")
public class EntitycustomerResource {

    private final Logger log = LoggerFactory.getLogger(EntitycustomerResource.class);

    private static final String ENTITY_NAME = "entitycustomer";

    private final EntitycustomerService entitycustomerService;

    public EntitycustomerResource(EntitycustomerService entitycustomerService) {
        this.entitycustomerService = entitycustomerService;
    }

    /**
     * POST  /entitycustomers : Create a new entitycustomer.
     *
     * @param entitycustomerDTO the entitycustomerDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new entitycustomerDTO, or with status 400 (Bad Request) if the entitycustomer has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/entitycustomers")
    @Timed
    public ResponseEntity<EntitycustomerDTO> createEntitycustomer(@RequestBody EntitycustomerDTO entitycustomerDTO) throws URISyntaxException {
        log.debug("REST request to save Entitycustomer : {}", entitycustomerDTO);
        if (entitycustomerDTO.getId() != null) {
            throw new BadRequestAlertException("A new entitycustomer cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EntitycustomerDTO result = entitycustomerService.save(entitycustomerDTO);
        return ResponseEntity.created(new URI("/api/entitycustomers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /entitycustomers : Updates an existing entitycustomer.
     *
     * @param entitycustomerDTO the entitycustomerDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated entitycustomerDTO,
     * or with status 400 (Bad Request) if the entitycustomerDTO is not valid,
     * or with status 500 (Internal Server Error) if the entitycustomerDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/entitycustomers")
    @Timed
    public ResponseEntity<EntitycustomerDTO> updateEntitycustomer(@RequestBody EntitycustomerDTO entitycustomerDTO) throws URISyntaxException {
        log.debug("REST request to update Entitycustomer : {}", entitycustomerDTO);
        if (entitycustomerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EntitycustomerDTO result = entitycustomerService.save(entitycustomerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, entitycustomerDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /entitycustomers : get all the entitycustomers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of entitycustomers in body
     */
    @GetMapping("/entitycustomers")
    @Timed
    public ResponseEntity<List<EntitycustomerDTO>> getAllEntitycustomers(Pageable pageable) {
        log.debug("REST request to get a page of Entitycustomers");
        Page<EntitycustomerDTO> page = entitycustomerService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/entitycustomers");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /entitycustomers/:id : get the "id" entitycustomer.
     *
     * @param id the id of the entitycustomerDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the entitycustomerDTO, or with status 404 (Not Found)
     */
    @GetMapping("/entitycustomers/{id}")
    @Timed
    public ResponseEntity<EntitycustomerDTO> getEntitycustomer(@PathVariable Long id) {
        log.debug("REST request to get Entitycustomer : {}", id);
        Optional<EntitycustomerDTO> entitycustomerDTO = entitycustomerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(entitycustomerDTO);
    }

    /**
     * DELETE  /entitycustomers/:id : delete the "id" entitycustomer.
     *
     * @param id the id of the entitycustomerDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/entitycustomers/{id}")
    @Timed
    public ResponseEntity<Void> deleteEntitycustomer(@PathVariable Long id) {
        log.debug("REST request to delete Entitycustomer : {}", id);
        entitycustomerService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
