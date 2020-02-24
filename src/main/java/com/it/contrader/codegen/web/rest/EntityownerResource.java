package com.it.contrader.codegen.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.it.contrader.codegen.service.EntityownerService;
import com.it.contrader.codegen.web.rest.errors.BadRequestAlertException;
import com.it.contrader.codegen.web.rest.util.HeaderUtil;
import com.it.contrader.codegen.web.rest.util.PaginationUtil;
import com.it.contrader.codegen.service.dto.EntityownerDTO;
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
 * REST controller for managing Entityowner.
 */
@RestController
@RequestMapping("/api")
public class EntityownerResource {

    private final Logger log = LoggerFactory.getLogger(EntityownerResource.class);

    private static final String ENTITY_NAME = "entityowner";

    private final EntityownerService entityownerService;

    public EntityownerResource(EntityownerService entityownerService) {
        this.entityownerService = entityownerService;
    }

    /**
     * POST  /entityowners : Create a new entityowner.
     *
     * @param entityownerDTO the entityownerDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new entityownerDTO, or with status 400 (Bad Request) if the entityowner has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/entityowners")
    @Timed
    public ResponseEntity<EntityownerDTO> createEntityowner(@RequestBody EntityownerDTO entityownerDTO) throws URISyntaxException {
        log.debug("REST request to save Entityowner : {}", entityownerDTO);
        if (entityownerDTO.getId() != null) {
            throw new BadRequestAlertException("A new entityowner cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EntityownerDTO result = entityownerService.save(entityownerDTO);
        return ResponseEntity.created(new URI("/api/entityowners/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /entityowners : Updates an existing entityowner.
     *
     * @param entityownerDTO the entityownerDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated entityownerDTO,
     * or with status 400 (Bad Request) if the entityownerDTO is not valid,
     * or with status 500 (Internal Server Error) if the entityownerDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/entityowners")
    @Timed
    public ResponseEntity<EntityownerDTO> updateEntityowner(@RequestBody EntityownerDTO entityownerDTO) throws URISyntaxException {
        log.debug("REST request to update Entityowner : {}", entityownerDTO);
        if (entityownerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EntityownerDTO result = entityownerService.save(entityownerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, entityownerDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /entityowners : get all the entityowners.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of entityowners in body
     */
    @GetMapping("/entityowners")
    @Timed
    public ResponseEntity<List<EntityownerDTO>> getAllEntityowners(Pageable pageable) {
        log.debug("REST request to get a page of Entityowners");
        Page<EntityownerDTO> page = entityownerService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/entityowners");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /entityowners/:id : get the "id" entityowner.
     *
     * @param id the id of the entityownerDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the entityownerDTO, or with status 404 (Not Found)
     */
    @GetMapping("/entityowners/{id}")
    @Timed
    public ResponseEntity<EntityownerDTO> getEntityowner(@PathVariable Long id) {
        log.debug("REST request to get Entityowner : {}", id);
        Optional<EntityownerDTO> entityownerDTO = entityownerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(entityownerDTO);
    }

    /**
     * DELETE  /entityowners/:id : delete the "id" entityowner.
     *
     * @param id the id of the entityownerDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/entityowners/{id}")
    @Timed
    public ResponseEntity<Void> deleteEntityowner(@PathVariable Long id) {
        log.debug("REST request to delete Entityowner : {}", id);
        entityownerService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
