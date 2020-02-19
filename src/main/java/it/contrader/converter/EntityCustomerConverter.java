package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.model.EntityCustomer;
import it.contrader.dto.EntityCustomerDTO;

 @Component
public class EntityCustomerConverter extends AbstractConverter<EntityCustomer, EntityCustomerDTO> {

	@Override
	public EntityCustomer toEntity(EntityCustomerDTO entityCustomerDTO) {
		EntityCustomer entityCustomer = null;
		if (entityCustomerDTO != null) {
			entityCustomer = new EntityCustomer(entityCustomerDTO.getId(), entityCustomerDTO.getName(), entityCustomerDTO.getProject());
		}
		return entityCustomer;
	}

	@Override
	public EntityCustomerDTO toDTO(EntityCustomer entityCustomer) {
		EntityCustomerDTO entityCustomerDTO = null;
		if (entityCustomer != null) {
			entityCustomerDTO = new EntityCustomerDTO(entityCustomer.getId(), entityCustomer.getName(),entityCustomer.getProject());

		}
		return entityCustomerDTO;
	}
}




