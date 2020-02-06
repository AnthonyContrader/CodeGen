package it.contrader.dao;
import javax.transaction.Transactional;
import it.contrader.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.EntityOwner;
@Repository
@Transactional
public interface EntityOwnerRepository extends CrudRepository<EntityOwner, Long>{
	
	EntityOwner findByNameAndProject(String name, Project project);
}
 
