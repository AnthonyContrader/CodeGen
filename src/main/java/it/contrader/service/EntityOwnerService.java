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

	public EntityOwnerDTO findByNameAndIdproject(String name, Project idproject) {
		return converter.toDTO(repository.findByNameAndIdproject(name, idproject));
	}


}

