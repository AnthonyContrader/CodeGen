package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ProjectRepository;
import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;

@Service
public class ProjectService extends AbstractService<Project, ProjectDTO> {

	public ProjectDTO findByNameAndDescriptionAndShippingdate(String name, String description, String shippingdate) {
		return converter.toDTO(((ProjectRepository)repository).findByNameAndDescriptionAndShippingdate(name, description, shippingdate));
	}

}
