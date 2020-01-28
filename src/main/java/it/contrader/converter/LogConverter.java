package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;


import it.contrader.dto.LogDTO;
import it.contrader.model.Log;

/**
 * 
 * @author Depy
 * 
 */
public class LogConverter  implements Converter<Log, LogDTO> {
	
	@Override
	public LogDTO toDTO(Log log) {
		LogDTO logDTO = new LogDTO(log.getId(), log.getAction(), log.getIduser(), log.getDate());
		return logDTO;
	}

	@Override
	public Log toEntity(LogDTO logDTO) {
		Log log = new Log(logDTO.getId(), logDTO.getAction(), logDTO.getIduser(), logDTO.getDate());
		return log;
	}
	
	@Override
	public List<LogDTO> toDTOList(List<Log> logList) {
		//Crea una lista vuota.
		List<LogDTO> logDTOList = new ArrayList<LogDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Log log : logList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			logDTOList.add(toDTO(log));
		}
		return logDTOList;
	}

	
	
}
