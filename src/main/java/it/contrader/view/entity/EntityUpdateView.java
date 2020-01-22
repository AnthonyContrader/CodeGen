package it.contrader.view.entity;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EntityUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String name;
	
	private final String mode = "UPDATE";

	public EntityUpdateView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Entity", null);
		}
	}

	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'entità:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci name dell'entità:");
			name = getInput();
			
		} catch (Exception e) {

		}
	}


	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Entity", "doControl", request);
	}


}
