package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.RelationshipDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Salvatore
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class RelationshipView extends AbstractView {

	private Request request;
	private String choice;

	public RelationshipView() {
		
	}

	/**
	 * Mostra la lista 
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione relazioni tra entità ----------------\n");
			System.out.println("ID\tEntity1\tEntity2\t");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<RelationshipDTO> relationships = (List<RelationshipDTO>) request.get("relationships");
			for (RelationshipDTO u: relationships)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi RelationshipController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[1]Leggi [2]Inserisci [3]Modifica [4]Cancella [5]Menù [6]Esci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda al RelationshipController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Relationship", "doControl", this.request);
	}

}
