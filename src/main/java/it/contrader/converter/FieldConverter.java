package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.FieldDTO;
import it.contrader.model.Field;

@Component
public class FieldConverter extends AbstractConverter<Field, FieldDTO> {

	@Override
	public Field toEntity(FieldDTO fieldDTO) {
		Field field = null;
		if (fieldDTO != null) {
			field = new Field(fieldDTO.getEntityowner(), fieldDTO.getId(), fieldDTO.getName(), fieldDTO.getType(), fieldDTO.getLenght());
		}
		return field;
	}

	@Override
	public FieldDTO toDTO(Field field) {
		FieldDTO fieldDTO = null;
		if (field != null) {
			fieldDTO = new FieldDTO(field.getEntityowner(), field.getId(), field.getName(), field.getType(), field.getLenght() );
		}
		return fieldDTO;
	}
}