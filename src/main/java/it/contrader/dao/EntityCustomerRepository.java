package it.contrader.dao;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Project;
import it.contrader.model.EntityCustomer;
@Repository
@Transactional
public interface EntityCustomerRepository extends CrudRepository<EntityCustomer, Long>{
	
	EntityCustomer findByNameAndProject(String name, Project project);
}
 
