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
			field = new Field(fieldDTO.getId(), fieldDTO.getName(), fieldDTO.getType(), fieldDTO.getIdentity(),fieldDTO.getLenght());
		}
		return field;
	}

	@Override
	public FieldDTO toDTO(Field field) {
		FieldDTO fieldDTO = null;
		if (field != null) {
			fieldDTO = new FieldDTO(field.getId(), field.getName(), field.getType(), field.getIdentity(),field.getLenght());
			

		}
		return fieldDTO;
	}
}