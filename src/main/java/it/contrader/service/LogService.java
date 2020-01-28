package it.contrader.service;

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
	

}
