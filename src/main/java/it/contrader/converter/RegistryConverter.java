package it.contrader.converter;

	import java.util.ArrayList;
	import java.util.List;

	import it.contrader.dto.RegistryDTO;
	import it.contrader.model.Registry;

	/**
	 * 
	 * @author Vittorio, De Santis 
	 *
	 */
	public class RegistryConverter   {
		
		/**
		 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
		 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
		 */
		public RegistryDTO toDTO(Registry registry) {
			RegistryDTO registryDTO = new RegistryDTO(registry.getId(), registry.getQuestion(), registry.getIdquest());
			return registryDTO;
		}

		/**
		 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
		 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
		 */
		public Registry toEntity(RegistryDTO registryDTO) {
			Registry registry = new Registry(registryDTO.getId(), registryDTO.getQuestion(), registryDTO.getIdquest());
			return registry;
		}
		
		/**
		 * Metodo per convertire le liste di User.
		 */
		public List<RegistryDTO> toDTOList(List<Registry> registryList) {
			//Crea una lista vuota.
			List<RegistryDTO> registryDTOList = new ArrayList<RegistryDTO>();
			
			//Cicla tutti gli elementi della lista e li converte uno a uno
			for(Registry registry : registryList) {
				//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
				//e lo aggiunge adda lista di DTO
				registryDTOList.add(toDTO(registry));
			}
			return registryDTOList;
		}

		
		
	}



