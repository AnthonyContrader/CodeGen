package it.contrader.service;

import it.contrader.converter.EntityConverter;
import it.contrader.dao.EntityDAO;
import it.contrader.dto.EntityDTO;
import it.contrader.model.Entity;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class EntityService extends AbstractService<Entity, EntityDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public EntityService(){
		this.dao = new EntityDAO();
		this.converter = new EntityConverter();
	}
	

}
