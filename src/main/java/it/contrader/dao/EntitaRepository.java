package it.contrader.dao;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Entita;
@Repository
@Transactional
public interface EntitaRepository extends CrudRepository<Entita, Long>{
	
	Entita findByNameAndIdproject(String name, Long idproject);
}
 