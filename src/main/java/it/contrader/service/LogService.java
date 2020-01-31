package it.contrader.service;

import java.util.List;

import it.contrader.converter.LogConverter;
import it.contrader.dao.LogDAO;
import it.contrader.dto.LogDTO;
import it.contrader.model.Log;

/**
 * 
 * @author Depy
 *
 */
public class LogService extends AbstractService<Log, LogDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public LogService(){
		this.dao = new LogDAO();
		this.converter = new LogConverter();
	}
	
	
	public List<LogDTO>  readByUsername(String username) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return converter.toDTOList(((LogDAO) dao).readByUsername(username));
	}
}
