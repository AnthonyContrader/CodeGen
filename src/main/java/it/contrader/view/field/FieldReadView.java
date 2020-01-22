package it.contrader.view.field;

import it.contrader.controller.Request;
import it.contrader.dto.FieldDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Depy
 *
 */
public class FieldReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public FieldReadView() {
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			FieldDTO field = (FieldDTO) request.get("field");
			System.out.println(field);
			MainDispatcher.getInstance().callView("Field", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del Campo:");
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
