package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.model.Entita;
import it.contrader.dto.EntitaDTO;

 @Component
public class EntitaConverter extends AbstractConverter<Entita, EntitaDTO> {

	@Override
	public Entita toEntity(EntitaDTO entitaDTO) {
		Entita entita = null;
		if (entitaDTO != null) {
			entita = new Entita(entitaDTO.getId(), entitaDTO.getName(), entitaDTO.getIdproject());
		}
		return entita;
	}

	@Override
	public EntitaDTO toDTO(Entita entita) {
		EntitaDTO entitaDTO = null;
		if (entita != null) {
			entitaDTO = new EntitaDTO(entita.getId(), entita.getName(), entita.getIdproject());

		}
		return entitaDTO;
	}
}


