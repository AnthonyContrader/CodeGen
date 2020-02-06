package it.contrader.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import it.contrader.converter.EntityOwnerConverter;

import it.contrader.dao.EntityOwnerRepository;
import it.contrader.dto.EntityOwnerDTO;
import it.contrader.model.EntityOwner;
import it.contrader.model.Project;
@Service
public class EntityOwnerService extends AbstractService<EntityOwner, EntityOwnerDTO> {

	@Autowired
	private EntityOwnerConverter converter;
	@Autowired
	private EntityOwnerRepository repository;

	public EntityOwnerDTO findByNameAndProject(String name, Project project) {
		return converter.toDTO(repository.findByNameAndProject(name, project));
	}


}

