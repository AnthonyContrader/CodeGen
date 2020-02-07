package it.contrader.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.LogConverter;
import it.contrader.dao.LogRepository;
import it.contrader.dto.LogDTO;
import it.contrader.model.Log;

@Service
public class LogService extends AbstractService<Log, LogDTO> {

	@Autowired
	private LogConverter converter;
	@Autowired
	private LogRepository repository;

	public LogDTO findByUserAndActionAndMoment(String user, String action, Date moment) {
		return converter.toDTO(repository.findByUserAndActionAndMoment( user,  action,  moment));
	}

}
