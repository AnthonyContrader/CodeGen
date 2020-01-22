package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.RelationshipDTO;
import it.contrader.model.Relationship;

/**
 * 
 * @author Salvatore
 *
 */
public class RelationshipConverter   {
	
	/**
	 * Crea un oggetto di tipo RelationshipDTO e lo riempie con i campi del parametro relationship di tipo Relationship.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public RelationshipDTO toDTO(Relationship relationship) {
		RelationshipDTO relationshipDTO = new RelationshipDTO(relationship.getId(), relationship.getEntity1(), relationship.getEntity2());
		return relationshipDTO;
	}

	/**
	 * Crea un oggetto di tipo Relationship e lo riempie con i campi del parametro user di tipo RelationshipDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Relationship toEntity(RelationshipDTO relationshipDTO) {
		Relationship relationship = new Relationship(relationshipDTO.getId(), relationshipDTO.getEntity1(), relationshipDTO.getEntity2());
		return relationship;
	}
	
	/**
	 * Metodo per convertire le liste di Relationship.
	 */
	public List<RelationshipDTO> toDTOList(List<Relationship> relationshipList) {
		//Crea una lista vuota.
		List<RelationshipDTO> relationshipDTOList = new ArrayList<RelationshipDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Relationship relationship : relationshipList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			relationshipDTOList.add(toDTO(relationship));
		}
		return relationshipDTOList;
	}

	
	
}
