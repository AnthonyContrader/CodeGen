package it.contrader.controller;

import java.util.List;

import it.contrader.dto.RelationshipDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.RelationshipService;

/**
 * 
 * @author Salvatore
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class RelationshipController implements Controller {

	/**
	 * definisce il pacchetto di vista relationship.
	 */
	private static String sub_package = "relationship.";
	
	private RelationshipService relationshipService;
	/**
	 * Costruisce un oggetto di tipo RelationshipService per poterne usare i metodi
	 */
	public RelationshipController() {
		this.relationshipService = new RelationshipService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta della relazione.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String entity1;
		String entity2;

		switch (mode) {
		
		// Arriva qui dalla RelationshipReadView. Invoca il Service con il parametro id e invia alla RelationshipReadView una relationship da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			RelationshipDTO relationshipDTO = relationshipService.read(id);
			request.put("relationship", relationshipDTO);
			MainDispatcher.getInstance().callView(sub_package + "RelationshipRead", request);
			break;
		
		// Arriva qui dalla RelationshipInsertView. Estrae i parametri da inserire e chiama il service per inserire una relationship con questi parametri
		case "INSERT":
			entity1 = request.get("entity1").toString();
			entity2 = request.get("entity2").toString();
			
			//costruisce l'oggetto user da inserire
			RelationshipDTO relationshiptoinsert = new RelationshipDTO(entity1, entity2);
			//invoca il service
			relationshipService.insert(relationshiptoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "RelationshipInsert", request);
			break;
		
		// Arriva qui dalla RelationshipDeleteView. Estrae l'id della relazione da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			relationshipService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "RelationshipDelete", request);
			break;
		
		// Arriva qui dalla RelationshipUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			entity1 = request.get("entity1").toString();
			entity2 = request.get("entity2").toString();
			RelationshipDTO relationshiptoupdate = new RelationshipDTO(entity1, entity2);
			relationshiptoupdate.setId(id);
			relationshipService.update(relationshiptoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "RelationshipUpdate", request);
			break;
			
		//Arriva qui dalla RelationshipView Invoca il Service e invia alla RelationshipView il risultato da mostrare 
		case "RELATIONSHIPLIST":
			List<RelationshipDTO> relationshipsDTO = relationshipService.getAll();
			//Impacchetta la request con la lista delle relationships
			request.put("relationships", relationshipsDTO);
			MainDispatcher.getInstance().callView("Relationship", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "1":
				MainDispatcher.getInstance().callView(sub_package + "RelationshipRead", null);
				break;
				
			case "2":
				MainDispatcher.getInstance().callView(sub_package + "RelationshipInsert", null);
				break;
				
			case "3":
				MainDispatcher.getInstance().callView(sub_package + "RelationshipUpdate", null);
				break;
				
			case "4":
				MainDispatcher.getInstance().callView(sub_package + "RelationshipDelete", null);
				break;
				
			case "5":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;

			case "6":
				MainDispatcher.getInstance().callView("Login", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
