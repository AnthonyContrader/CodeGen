package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Log;

@Repository
@Transactional
public interface LogRepository extends CrudRepository<Log, Long> {

	Log findByUserAndActionAndMoment(String user, String action, String moment);

}
