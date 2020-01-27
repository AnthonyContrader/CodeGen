package it.contrader.service;

import java.util.List;


import it.contrader.converter.FieldConverter;
import it.contrader.dao.FieldDAO;
import it.contrader.dto.FieldDTO;

/**
 * 
 * @author Depy
 *
 */
public class FieldService {
	
	private FieldDAO fieldDAO;
	private FieldConverter fieldConverter;
	
	public FieldService(){
		this.fieldDAO = new FieldDAO();
		this.fieldConverter = new FieldConverter();
	}
	
	public List<FieldDTO> getAll() {
		return fieldConverter.toDTOList(fieldDAO.getAll());
	}

	public FieldDTO read(int id) {
		return fieldConverter.toDTO(fieldDAO.read(id));
	}

	public boolean insert(FieldDTO dto) {
		return fieldDAO.insert(fieldConverter.toEntity(dto));
	}

	public boolean update(FieldDTO dto) {
		return fieldDAO.update(fieldConverter.toEntity(dto));
	}

	public boolean delete(int id) {
		return fieldDAO.delete(id);
	}
	

}
