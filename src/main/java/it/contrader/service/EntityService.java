package it.contrader.service;

import java.util.List;

import it.contrader.converter.EntityConverter;
import it.contrader.dao.EntityDAO;
import it.contrader.dto.EntityDTO;
/*
 * 
 * @author Selenia, Brunco 
 *
 */

public class EntityService {
	private EntityDAO entityDAO;
	private EntityConverter entityConverter;

	public EntityService(){
		this.entityDAO = new EntityDAO();
		this.entityConverter = new EntityConverter();
	}
	

	public List<EntityDTO> getAll() {
		
		return entityConverter.toDTOList(entityDAO.getAll());
	}


	public EntityDTO read(int id) {
		
		return entityConverter.toDTO(entityDAO.read(id));
	}


	public boolean insert(EntityDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return entityDAO.insert(entityConverter.toEntity(dto));
	}


	public boolean update(EntityDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return entityDAO.update(entityConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return entityDAO.delete(id);
	}
	

}
