package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.RelationshipRepository;
import it.contrader.dto.RelationshipDTO;
import it.contrader.model.EntityCustomer;
import it.contrader.model.EntityOwner;
import it.contrader.model.Relationship;

@Service
public class RelationshipService extends AbstractService<Relationship, RelationshipDTO> {

	public RelationshipDTO findByEntityownerAndEntitycustomer(EntityOwner entityowner, EntityCustomer entitycustomer) {
		return converter.toDTO(((RelationshipRepository)repository).findByEntityownerAndEntitycustomer(entityowner, entitycustomer));
	}

}
