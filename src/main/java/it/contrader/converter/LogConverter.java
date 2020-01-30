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
		LogDTO logDTO = new LogDTO(log.getId(), log.getAction(), log.getUser(), log.getDate());
		return logDTO;
	}

	@Override
	public Log toEntity(LogDTO logDTO) {
		Log log = new Log(logDTO.getId(), logDTO.getAction(), logDTO.getUser(), logDTO.getDate());
		return log;
	}
	
	@Override
	public List<LogDTO> toDTOList(List<Log> logList) {
		List<LogDTO> logDTOList = new ArrayList<LogDTO>();
		
		for(Log log : logList) {
			logDTOList.add(toDTO(log));
		}
		return logDTOList;
	}

	
	
}
