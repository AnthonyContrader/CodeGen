package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.FieldConverter;
import it.contrader.dao.FieldRepository;
import it.contrader.dto.FieldDTO;
import it.contrader.model.Field;

@Service
public class FieldService extends AbstractService<Field, FieldDTO> {

	@Autowired
	private FieldConverter converter;
	@Autowired
	private FieldRepository repository;

	public FieldDTO findByNameAndTypeAndIdentityAndLenght(String name, String type,Long identity,Long lenght) {
		return converter.toDTO(repository.findByNameAndTypeAndIdentityAndLenght(name, type, identity, lenght));
	}

}
