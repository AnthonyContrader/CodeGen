package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.FieldDTO;
import it.contrader.model.Field;

/**
 * 
 * @author Depy 
 *
 */
public class FieldConverter   {
	
	public FieldDTO toDTO(Field field) {
		FieldDTO fieldDTO = new FieldDTO(field.getId(), field.getName(), field.getType(), field.getEntity());
		return fieldDTO;
	}

	
	public Field toEntity(FieldDTO fieldDTO) {
		Field field = new Field(fieldDTO.getId(), fieldDTO.getName(), fieldDTO.getType(), fieldDTO.getEntity());
		return field;
	}


	public List<FieldDTO> toDTOList(List<Field> fieldList) {
		List<FieldDTO> fieldDTOList = new ArrayList<FieldDTO>();
		
		for(Field field : fieldList) 
			fieldDTOList.add(toDTO(field));
		
		return fieldDTOList;
	}

	
	
}
