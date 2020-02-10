package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.EntityOwnerRepository;
import it.contrader.dao.FieldRepository;
import it.contrader.dto.FieldDTO;
import it.contrader.model.Field;

@Service
public class FieldService extends AbstractService<Field,FieldDTO> {
	
	public FieldDTO findByEntityowner(EntityOwner  entityowner) {
		return converter.toDTO(((FieldRepository)repository).findByEntityowner(EntityOwner  entityowner));
	}
	
	public FieldDTO findByEntityownerAndNameAndTypeAndLenght(EntityOwner entityowner, String name, String type, Long lenght) {
		return converter.toDTO(((FieldRepository)repository).findByEntityownerAndNameAndTypeAndLenght( entityowner,  name,  type,  lenght));
	}

}
