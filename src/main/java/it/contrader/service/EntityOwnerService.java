package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.EntityOwnerRepository;
import it.contrader.dto.EntityOwnerDTO;
import it.contrader.model.EntityOwner;
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
public class EntityOwnerService extends AbstractService<EntityOwner,EntityOwnerDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public EntityOwnerDTO findByUsernameAndPassword(String name, Project project) {
		return converter.toDTO(((EntityOwnerRepository)repository).findByNameAndProject(name, project));
	}

}

