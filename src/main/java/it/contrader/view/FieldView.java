package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.FieldDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Depy
 *
 */
public class FieldView extends AbstractView {

	private Request request;
	private String choice;

	public FieldView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Campi di tutte le entita' ----------------\n");
			System.out.println("ID\tNome\tTipo\tEntita' Collegata");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<FieldDTO> fields = (List<FieldDTO>) request.get("fields");
			for (FieldDTO f: fields)
				System.out.println(f);
			System.out.println();
		}
	}

	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();		
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Field", "doControl", this.request);
	}

}
