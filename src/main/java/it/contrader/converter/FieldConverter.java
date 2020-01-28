package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.FieldDTO;
import it.contrader.model.Field;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe FieldConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class FieldConverter  implements Converter<Field, FieldDTO> {
	
	/**
	 * Crea un oggetto di tipo FieldDTO e lo riempie con i campi del parametro field di tipo Field.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public FieldDTO toDTO(Field field) {
		FieldDTO fieldDTO = new FieldDTO(field.getId(), field.getName(), field.getType(), field.getEntity());
		return fieldDTO;
	}

	/**
	 * Crea un oggetto di tipo Field e lo riempie con i campi del parametro field di tipo FieldDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Field toEntity(FieldDTO fieldDTO) {
		Field field = new Field(fieldDTO.getId(), fieldDTO.getName(), fieldDTO.getType(), fieldDTO.getEntity());
		return field;
	}
	
	/**
	 * Metodo per convertire le liste di Field.
	 */
	@Override
	public List<FieldDTO> toDTOList(List<Field> fieldList) {
		//Crea una lista vuota.
		List<FieldDTO> fieldDTOList = new ArrayList<FieldDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Field field : fieldList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			fieldDTOList.add(toDTO(field));
		}
		return fieldDTOList;
	}

	
	
}
