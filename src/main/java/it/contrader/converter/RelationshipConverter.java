package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.RelationshipDTO;

import it.contrader.model.Relationship;

@Component
public class RelationshipConverter extends AbstractConverter<Relationship, RelationshipDTO> {

	@Override
	public Relationship toEntity(RelationshipDTO relationshipDTO) {
		Relationship relationship = null;
		if (relationshipDTO != null) {
			relationship = new Relationship(relationshipDTO.getId(), relationshipDTO.getEntityowner(), relationshipDTO.getEntitycustomer());
		}
		return relationship;
	}

	@Override
	public RelationshipDTO toDTO(Relationship relationship) {
		RelationshipDTO relationshipDTO = null;
		if (relationship != null) {
			relationshipDTO = new RelationshipDTO(relationship.getId(), relationship.getEntityowner(), relationship.getEntitycustomer());

		}
		return relationshipDTO;
	}
}