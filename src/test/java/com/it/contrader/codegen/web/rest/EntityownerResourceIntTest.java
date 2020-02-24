package com.it.contrader.codegen.web.rest;

import com.it.contrader.codegen.CodegenApp;

import com.it.contrader.codegen.domain.Entityowner;
import com.it.contrader.codegen.repository.EntityownerRepository;
import com.it.contrader.codegen.service.EntityownerService;
import com.it.contrader.codegen.service.dto.EntityownerDTO;
import com.it.contrader.codegen.service.mapper.EntityownerMapper;
import com.it.contrader.codegen.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static com.it.contrader.codegen.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the EntityownerResource REST controller.
 *
 * @see EntityownerResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CodegenApp.class)
public class EntityownerResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    @Autowired
    private EntityownerRepository entityownerRepository;


    @Autowired
    private EntityownerMapper entityownerMapper;
    

    @Autowired
    private EntityownerService entityownerService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restEntityownerMockMvc;

    private Entityowner entityowner;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final EntityownerResource entityownerResource = new EntityownerResource(entityownerService);
        this.restEntityownerMockMvc = MockMvcBuilders.standaloneSetup(entityownerResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Entityowner createEntity(EntityManager em) {
        Entityowner entityowner = new Entityowner()
            .name(DEFAULT_NAME);
        return entityowner;
    }

    @Before
    public void initTest() {
        entityowner = createEntity(em);
    }

    @Test
    @Transactional
    public void createEntityowner() throws Exception {
        int databaseSizeBeforeCreate = entityownerRepository.findAll().size();

        // Create the Entityowner
        EntityownerDTO entityownerDTO = entityownerMapper.toDto(entityowner);
        restEntityownerMockMvc.perform(post("/api/entityowners")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(entityownerDTO)))
            .andExpect(status().isCreated());

        // Validate the Entityowner in the database
        List<Entityowner> entityownerList = entityownerRepository.findAll();
        assertThat(entityownerList).hasSize(databaseSizeBeforeCreate + 1);
        Entityowner testEntityowner = entityownerList.get(entityownerList.size() - 1);
        assertThat(testEntityowner.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    public void createEntityownerWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = entityownerRepository.findAll().size();

        // Create the Entityowner with an existing ID
        entityowner.setId(1L);
        EntityownerDTO entityownerDTO = entityownerMapper.toDto(entityowner);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEntityownerMockMvc.perform(post("/api/entityowners")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(entityownerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Entityowner in the database
        List<Entityowner> entityownerList = entityownerRepository.findAll();
        assertThat(entityownerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllEntityowners() throws Exception {
        // Initialize the database
        entityownerRepository.saveAndFlush(entityowner);

        // Get all the entityownerList
        restEntityownerMockMvc.perform(get("/api/entityowners?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(entityowner.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())));
    }
    

    @Test
    @Transactional
    public void getEntityowner() throws Exception {
        // Initialize the database
        entityownerRepository.saveAndFlush(entityowner);

        // Get the entityowner
        restEntityownerMockMvc.perform(get("/api/entityowners/{id}", entityowner.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(entityowner.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingEntityowner() throws Exception {
        // Get the entityowner
        restEntityownerMockMvc.perform(get("/api/entityowners/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEntityowner() throws Exception {
        // Initialize the database
        entityownerRepository.saveAndFlush(entityowner);

        int databaseSizeBeforeUpdate = entityownerRepository.findAll().size();

        // Update the entityowner
        Entityowner updatedEntityowner = entityownerRepository.findById(entityowner.getId()).get();
        // Disconnect from session so that the updates on updatedEntityowner are not directly saved in db
        em.detach(updatedEntityowner);
        updatedEntityowner
            .name(UPDATED_NAME);
        EntityownerDTO entityownerDTO = entityownerMapper.toDto(updatedEntityowner);

        restEntityownerMockMvc.perform(put("/api/entityowners")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(entityownerDTO)))
            .andExpect(status().isOk());

        // Validate the Entityowner in the database
        List<Entityowner> entityownerList = entityownerRepository.findAll();
        assertThat(entityownerList).hasSize(databaseSizeBeforeUpdate);
        Entityowner testEntityowner = entityownerList.get(entityownerList.size() - 1);
        assertThat(testEntityowner.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingEntityowner() throws Exception {
        int databaseSizeBeforeUpdate = entityownerRepository.findAll().size();

        // Create the Entityowner
        EntityownerDTO entityownerDTO = entityownerMapper.toDto(entityowner);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restEntityownerMockMvc.perform(put("/api/entityowners")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(entityownerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Entityowner in the database
        List<Entityowner> entityownerList = entityownerRepository.findAll();
        assertThat(entityownerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteEntityowner() throws Exception {
        // Initialize the database
        entityownerRepository.saveAndFlush(entityowner);

        int databaseSizeBeforeDelete = entityownerRepository.findAll().size();

        // Get the entityowner
        restEntityownerMockMvc.perform(delete("/api/entityowners/{id}", entityowner.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Entityowner> entityownerList = entityownerRepository.findAll();
        assertThat(entityownerList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Entityowner.class);
        Entityowner entityowner1 = new Entityowner();
        entityowner1.setId(1L);
        Entityowner entityowner2 = new Entityowner();
        entityowner2.setId(entityowner1.getId());
        assertThat(entityowner1).isEqualTo(entityowner2);
        entityowner2.setId(2L);
        assertThat(entityowner1).isNotEqualTo(entityowner2);
        entityowner1.setId(null);
        assertThat(entityowner1).isNotEqualTo(entityowner2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EntityownerDTO.class);
        EntityownerDTO entityownerDTO1 = new EntityownerDTO();
        entityownerDTO1.setId(1L);
        EntityownerDTO entityownerDTO2 = new EntityownerDTO();
        assertThat(entityownerDTO1).isNotEqualTo(entityownerDTO2);
        entityownerDTO2.setId(entityownerDTO1.getId());
        assertThat(entityownerDTO1).isEqualTo(entityownerDTO2);
        entityownerDTO2.setId(2L);
        assertThat(entityownerDTO1).isNotEqualTo(entityownerDTO2);
        entityownerDTO1.setId(null);
        assertThat(entityownerDTO1).isNotEqualTo(entityownerDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(entityownerMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(entityownerMapper.fromId(null)).isNull();
    }
}
