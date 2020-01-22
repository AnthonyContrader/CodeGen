package it.contrader.view.relationship;

import it.contrader.controller.Request;

import it.contrader.dto.RelationshipDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Salvatore
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class RelationshipReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public RelationshipReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con una relationship nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra la relationship. In questo caso torna alla RelationshipView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			RelationshipDTO relationship = (RelationshipDTO) request.get("relationship");
			System.out.println(relationship);
			MainDispatcher.getInstance().callView("Relationship", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id della relazione da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della relazione:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id della relazione da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Relationship", "doControl", request);
	}

}
