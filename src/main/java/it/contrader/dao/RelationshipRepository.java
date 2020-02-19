package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.EntityCustomer;
import it.contrader.model.EntityOwner;
import it.contrader.model.Relationship;

@Repository
@Transactional
public interface RelationshipRepository extends CrudRepository<Relationship, Long> {

	Relationship findByEntityownerAndEntitycustomer(EntityOwner entityowner, EntityCustomer entitycustomer);

}
