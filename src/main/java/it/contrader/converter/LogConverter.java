package it.contrader.converter;



import org.springframework.stereotype.Component;

import it.contrader.dto.LogDTO;

import it.contrader.model.Log;

@Component
public class LogConverter extends AbstractConverter<Log, LogDTO> {

	@Override
	public Log toEntity(LogDTO logDTO) {
		Log log = null;
		if (logDTO != null) {
			log = new Log(logDTO.getId(), logDTO.getUsers(), logDTO.getAction(),  logDTO.getMoment());
		}
		return log;
	}

	@Override
	public LogDTO toDTO(Log log) {
		LogDTO logDTO = null;
		if (log != null) {
			logDTO = new LogDTO(log.getId(), log.getUsers(), log.getAction(), log.getMoment());

		}
		return logDTO;
	}
}