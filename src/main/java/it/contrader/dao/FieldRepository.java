package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.EntityOwner;
import it.contrader.model.Field;



@Repository
@Transactional
public interface FieldRepository extends CrudRepository<Field, Long> {
	
	Field findByEntityowner(EntityOwner  entityowner);

	Field findByEntityownerAndNameAndTypeAndLenght(EntityOwner entityowner, String name, String type, Long lenght);

}
