package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.EntityCustomerRepository;
import it.contrader.dto.EntityCustomerDTO;
import it.contrader.model.EntityCustomer;
import it.contrader.model.Project;

/**
 * Estende AbstractService con parametri User e UserDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class EntityCustomerService extends AbstractService<EntityCustomer,EntityCustomerDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public EntityCustomerDTO findByUsernameAndPassword(String name, Project project) {
		return converter.toDTO(((EntityCustomerRepository)repository).findByNameAndProject(name, project));
	}

}


