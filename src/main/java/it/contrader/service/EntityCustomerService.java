package it.contrader.service;
import org.springframework.beans.factory.annotation.Autowired;
import it.contrader.model.Project;
import org.springframework.stereotype.Service;
import it.contrader.converter.EntityCustomerConverter;

import it.contrader.dao.EntityCustomerRepository;
import it.contrader.dto.EntityCustomerDTO;
import it.contrader.model.EntityCustomer;

@Service
public class EntityCustomerService extends AbstractService<EntityCustomer, EntityCustomerDTO> {

	@Autowired
	private EntityCustomerConverter converter;
	@Autowired
	private EntityCustomerRepository repository;

	public EntityCustomerDTO findByNameAndProject(String name, Project project) {
		return converter.toDTO(repository.findByNameAndProject(name, project));
	}


}
