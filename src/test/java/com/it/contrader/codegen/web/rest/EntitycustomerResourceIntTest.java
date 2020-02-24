package com.it.contrader.codegen.web.rest;

import com.it.contrader.codegen.CodegenApp;

import com.it.contrader.codegen.domain.Entitycustomer;
import com.it.contrader.codegen.repository.EntitycustomerRepository;
import com.it.contrader.codegen.service.EntitycustomerService;
import com.it.contrader.codegen.service.dto.EntitycustomerDTO;
import com.it.contrader.codegen.service.mapper.EntitycustomerMapper;
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
 * Test class for the EntitycustomerResource REST controller.
 *
 * @see EntitycustomerResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CodegenApp.class)
public class EntitycustomerResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    @Autowired
    private EntitycustomerRepository entitycustomerRepository;


    @Autowired
    private EntitycustomerMapper entitycustomerMapper;
    

    @Autowired
    private EntitycustomerService entitycustomerService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restEntitycustomerMockMvc;

    private Entitycustomer entitycustomer;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final EntitycustomerResource entitycustomerResource = new EntitycustomerResource(entitycustomerService);
        this.restEntitycustomerMockMvc = MockMvcBuilders.standaloneSetup(entitycustomerResource)
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
    public static Entitycustomer createEntity(EntityManager em) {
        Entitycustomer entitycustomer = new Entitycustomer()
            .name(DEFAULT_NAME);
        return entitycustomer;
    }

    @Before
    public void initTest() {
        entitycustomer = createEntity(em);
    }

    @Test
    @Transactional
    public void createEntitycustomer() throws Exception {
        int databaseSizeBeforeCreate = entitycustomerRepository.findAll().size();

        // Create the Entitycustomer
        EntitycustomerDTO entitycustomerDTO = entitycustomerMapper.toDto(entitycustomer);
        restEntitycustomerMockMvc.perform(post("/api/entitycustomers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(entitycustomerDTO)))
            .andExpect(status().isCreated());

        // Validate the Entitycustomer in the database
        List<Entitycustomer> entitycustomerList = entitycustomerRepository.findAll();
        assertThat(entitycustomerList).hasSize(databaseSizeBeforeCreate + 1);
        Entitycustomer testEntitycustomer = entitycustomerList.get(entitycustomerList.size() - 1);
        assertThat(testEntitycustomer.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    public void createEntitycustomerWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = entitycustomerRepository.findAll().size();

        // Create the Entitycustomer with an existing ID
        entitycustomer.setId(1L);
        EntitycustomerDTO entitycustomerDTO = entitycustomerMapper.toDto(entitycustomer);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEntitycustomerMockMvc.perform(post("/api/entitycustomers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(entitycustomerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Entitycustomer in the database
        List<Entitycustomer> entitycustomerList = entitycustomerRepository.findAll();
        assertThat(entitycustomerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllEntitycustomers() throws Exception {
        // Initialize the database
        entitycustomerRepository.saveAndFlush(entitycustomer);

        // Get all the entitycustomerList
        restEntitycustomerMockMvc.perform(get("/api/entitycustomers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(entitycustomer.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())));
    }
    

    @Test
    @Transactional
    public void getEntitycustomer() throws Exception {
        // Initialize the database
        entitycustomerRepository.saveAndFlush(entitycustomer);

        // Get the entitycustomer
        restEntitycustomerMockMvc.perform(get("/api/entitycustomers/{id}", entitycustomer.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(entitycustomer.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingEntitycustomer() throws Exception {
        // Get the entitycustomer
        restEntitycustomerMockMvc.perform(get("/api/entitycustomers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEntitycustomer() throws Exception {
        // Initialize the database
        entitycustomerRepository.saveAndFlush(entitycustomer);

        int databaseSizeBeforeUpdate = entitycustomerRepository.findAll().size();

        // Update the entitycustomer
        Entitycustomer updatedEntitycustomer = entitycustomerRepository.findById(entitycustomer.getId()).get();
        // Disconnect from session so that the updates on updatedEntitycustomer are not directly saved in db
        em.detach(updatedEntitycustomer);
        updatedEntitycustomer
            .name(UPDATED_NAME);
        EntitycustomerDTO entitycustomerDTO = entitycustomerMapper.toDto(updatedEntitycustomer);

        restEntitycustomerMockMvc.perform(put("/api/entitycustomers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(entitycustomerDTO)))
            .andExpect(status().isOk());

        // Validate the Entitycustomer in the database
        List<Entitycustomer> entitycustomerList = entitycustomerRepository.findAll();
        assertThat(entitycustomerList).hasSize(databaseSizeBeforeUpdate);
        Entitycustomer testEntitycustomer = entitycustomerList.get(entitycustomerList.size() - 1);
        assertThat(testEntitycustomer.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingEntitycustomer() throws Exception {
        int databaseSizeBeforeUpdate = entitycustomerRepository.findAll().size();

        // Create the Entitycustomer
        EntitycustomerDTO entitycustomerDTO = entitycustomerMapper.toDto(entitycustomer);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restEntitycustomerMockMvc.perform(put("/api/entitycustomers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(entitycustomerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Entitycustomer in the database
        List<Entitycustomer> entitycustomerList = entitycustomerRepository.findAll();
        assertThat(entitycustomerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteEntitycustomer() throws Exception {
        // Initialize the database
        entitycustomerRepository.saveAndFlush(entitycustomer);

        int databaseSizeBeforeDelete = entitycustomerRepository.findAll().size();

        // Get the entitycustomer
        restEntitycustomerMockMvc.perform(delete("/api/entitycustomers/{id}", entitycustomer.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Entitycustomer> entitycustomerList = entitycustomerRepository.findAll();
        assertThat(entitycustomerList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Entitycustomer.class);
        Entitycustomer entitycustomer1 = new Entitycustomer();
        entitycustomer1.setId(1L);
        Entitycustomer entitycustomer2 = new Entitycustomer();
        entitycustomer2.setId(entitycustomer1.getId());
        assertThat(entitycustomer1).isEqualTo(entitycustomer2);
        entitycustomer2.setId(2L);
        assertThat(entitycustomer1).isNotEqualTo(entitycustomer2);
        entitycustomer1.setId(null);
        assertThat(entitycustomer1).isNotEqualTo(entitycustomer2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EntitycustomerDTO.class);
        EntitycustomerDTO entitycustomerDTO1 = new EntitycustomerDTO();
        entitycustomerDTO1.setId(1L);
        EntitycustomerDTO entitycustomerDTO2 = new EntitycustomerDTO();
        assertThat(entitycustomerDTO1).isNotEqualTo(entitycustomerDTO2);
        entitycustomerDTO2.setId(entitycustomerDTO1.getId());
        assertThat(entitycustomerDTO1).isEqualTo(entitycustomerDTO2);
        entitycustomerDTO2.setId(2L);
        assertThat(entitycustomerDTO1).isNotEqualTo(entitycustomerDTO2);
        entitycustomerDTO1.setId(null);
        assertThat(entitycustomerDTO1).isNotEqualTo(entitycustomerDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(entitycustomerMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(entitycustomerMapper.fromId(null)).isNull();
    }
}
