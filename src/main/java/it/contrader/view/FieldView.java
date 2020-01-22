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
			System.out.println("ID\tNome\tTipo\tEntita'");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<FieldDTO> fields = (List<FieldDTO>) request.get("fields");
			

			for (int i =0; i<fields.size(); i++) {
				System.out.println(fields.get(i));
			}
			
			System.out.println("\n____________________________________________________\n");
		}
	}

	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[1]Leggi [2]Inserisci [3]Modifica [4]Cancella [5]Torna [6]Esci");

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
