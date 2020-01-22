package it.contrader.view.field;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


/**
 * @author Depy
 */
public class FieldDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public FieldDeleteView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println(" La Cancellazione del Campo andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Field", null);
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Inserisci ID del Campo: ");
			id = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Field", "doControl", request);
	}


}
