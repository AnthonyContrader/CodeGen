package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EntityDTO;
import it.contrader.model.Entity;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe UserConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class EntityConverter  implements Converter<Entity, EntityDTO> {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public EntityDTO toDTO(Entity entity) {
		EntityDTO entityDTO = new EntityDTO(entity.getId(), entity.getName());
		return entityDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Entity toEntity(EntityDTO entityDTO) {
		Entity entity = new Entity(entityDTO.getId(), entityDTO.getName());
		return entity;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	@Override
	public List<EntityDTO> toDTOList(List<Entity> entityList) {
		//Crea una lista vuota.
		List<EntityDTO> entityDTOList = new ArrayList<EntityDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Entity entity : entityList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			entityDTOList.add(toDTO(entity));
		}
		return entityDTOList;
	}

	
	
}
