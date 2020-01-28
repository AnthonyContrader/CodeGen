package it.contrader.service;

import it.contrader.converter.FieldConverter;
import it.contrader.dao.FieldDAO;
import it.contrader.dto.FieldDTO;
import it.contrader.model.Field;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class FieldService extends AbstractService<Field, FieldDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public FieldService(){
		this.dao = new FieldDAO();
		this.converter = new FieldConverter();
	}
	

}
