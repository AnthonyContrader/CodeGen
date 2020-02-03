package it.contrader.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import it.contrader.converter.EntitaConverter;

import it.contrader.dao.EntitaRepository;
import it.contrader.dto.EntitaDTO;
import it.contrader.model.Entita;

@Service
public class EntitaService extends AbstractService<Entita, EntitaDTO> {

	@Autowired
	private EntitaConverter converter;
	@Autowired
	private EntitaRepository repository;

	public EntitaDTO findByNameAndIdproject(String name, Long idproject) {
		return converter.toDTO(repository.findByNameAndIdproject(name, idproject));
	}


}
