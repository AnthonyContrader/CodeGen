package it.contrader.service;

import java.util.List;


import it.contrader.converter.RelationshipConverter;
import it.contrader.dao.RelationshipDAO;
import it.contrader.dto.RelationshipDTO;

/**
 * 
 * @author Salvatore
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della classe AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class RelationshipService implements Service<RelationshipDTO> {
	
	private RelationshipDAO relationshipDAO;
	private RelationshipConverter relationshipConverter;
	
	//Istanzio DAO  e Converter specifici.
	public RelationshipService(){
		this.relationshipDAO = new RelationshipDAO();
		this.relationshipConverter = new RelationshipConverter();
	}
	

	public List<RelationshipDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return relationshipConverter.toDTOList(relationshipDAO.getAll());
	}


	public RelationshipDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return relationshipConverter.toDTO(relationshipDAO.read(id));
	}


	public boolean insert(RelationshipDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return relationshipDAO.insert(relationshipConverter.toEntity(dto));
	}


	public boolean update(RelationshipDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per la modifica
		return relationshipDAO.update(relationshipConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo metodo chiama direttamente il DAO
		return relationshipDAO.delete(id);
	}
	

}
