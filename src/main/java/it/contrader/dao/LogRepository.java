package it.contrader.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Log;

@Repository
@Transactional
public interface LogRepository extends CrudRepository<Log, Long> {

	Log findByUsersAndActionAndMoment(String users, String action, Date moment);

}
