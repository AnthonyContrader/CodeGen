package it.contrader.view.field;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * 
 * @author Depy
 *
 */

public class FieldUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String name;
	private String type;
	private String entity;
	private final String mode = "UPDATE";

	public FieldUpdateView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La modifica e' andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Field", null);
		}
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'utente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome del campo:");
			name = getInput();
			System.out.println("Inserisci il tipo del campo:");
			type = getInput();
			System.out.println("Inserisci l'entita' propretaria di questo campo:");
			entity = getInput();
		} catch (Exception e) {

		}
	}


	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("type", type);
		request.put("entity", entity);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Field", "doControl", request);
	}

}
