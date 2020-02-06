package it.contrader.dto;
import it.contrader.model.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
@NoArgsConstructor

	public class EntityOwnerDTO {

		private Long id;

		private String name;

		private Project project;



	}
