package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.EntityCustomer;
import it.contrader.model.EntityOwner;
import it.contrader.model.Field;
import it.contrader.model.Relationship;



@Repository
@Transactional
public interface FieldRepository extends CrudRepository<Field, Long> {
	
	Field findByEntityowner(EntityOwner  entityowner) ;

}
