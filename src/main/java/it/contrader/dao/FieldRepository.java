package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Field;

@Repository
@Transactional
public interface FieldRepository extends CrudRepository<Field, Long> {
	//@Query("")
	Field findByNameAndTypeAndIdentityAndLenght(String name, String type,Long identity,Long lenght);

}
