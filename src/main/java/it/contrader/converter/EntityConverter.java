package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EntityDTO;
import it.contrader.model.Entity;

public class EntityConverter {

	/*
	 * 
	 * @author Selenia, Brunco 
	 *
	 */

		
		
		
		public EntityDTO toDTO(Entity entity) {
			EntityDTO entityDTO = new EntityDTO(entity.getId(), entity.getName());
			return entityDTO;
		}

		
		public Entity toEntity(EntityDTO entityDTO) {
			Entity entity = new Entity(entityDTO.getId(), entityDTO.getName());
			return entity;
		}
		
		
		public List<EntityDTO> toDTOList(List<Entity> entityList) {
			
			List<EntityDTO> entityDTOList = new ArrayList<EntityDTO>();
			
			
			for(Entity entity : entityList) {
				
				entityDTOList.add(toDTO(entity));
			}
			return entityDTOList;
		}

}
