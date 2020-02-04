package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.model.EntityOwner;
import it.contrader.dto.EntityOwnerDTO;

 @Component
public class EntityOwnerConverter extends AbstractConverter<EntityOwner, EntityOwnerDTO> {

	@Override
	public EntityOwner toEntity(EntityOwnerDTO entityOwnerDTO) {
		EntityOwner entityOwner = null;
		if (entityOwnerDTO != null) {
			entityOwner = new EntityOwner(entityOwnerDTO.getId(), entityOwnerDTO.getName(), entityOwnerDTO.getIdproject());
		}
		return entityOwner;
	}

	@Override
	public EntityOwnerDTO toDTO(EntityOwner entityOwner) {
		EntityOwnerDTO entityOwnerDTO = null;
		if (entityOwner != null) {
			entityOwnerDTO = new EntityOwnerDTO(entityOwner.getId(), entityOwner.getName(), entityOwner.getIdproject());

		}
		return entityOwnerDTO;
	}
}




