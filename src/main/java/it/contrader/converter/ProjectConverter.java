package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ProjectDTO;

import it.contrader.model.Project;

@Component
public class ProjectConverter extends AbstractConverter<Project, ProjectDTO> {

	@Override
	public Project toEntity(ProjectDTO projectDTO) {
		Project project = null;
		if (projectDTO != null) {
			project = new Project(projectDTO.getId(), projectDTO.getName(), projectDTO.getDescription(), projectDTO.getShippingdate());
		}
		return project;
	}

	@Override
	public ProjectDTO toDTO(Project project) {
		ProjectDTO projectDTO = null;
		if (project != null) {
			projectDTO = new ProjectDTO(project.getId(), project.getName(), project.getDescription(), project.getShippingdate());

		}
		return projectDTO;
	}
}