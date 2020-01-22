package it.contrader.view.field;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Depy
 *
 */
public class FieldInsertView extends AbstractView{
	private Request request;

	private String name;
	private String type;
	private String entity;
	private final String mode = "INSERT";

	public FieldInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Field", null);
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Inserisci il nome del campo: ");
			name = getInput();
			System.out.println("Inserisci il tipo del campo: ");
			type = getInput();
			System.out.println("Inserisci l'entita' proprietaria del campo:");
			entity = getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("type", type);
		request.put("entity", entity);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Field", "doControl", request);
	}


}
