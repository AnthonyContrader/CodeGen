package it.contrader.view.entity;

import it.contrader.controller.Request;
import it.contrader.dto.EntityDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EntityReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public EntityReadView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			EntityDTO entity = (EntityDTO) request.get("entity");
			System.out.println(entity);
			MainDispatcher.getInstance().callView("Entity", null);
		}
	}

	
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'entità:");
		id = Integer.parseInt(getInput());
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Entity", "doControl", request);
	}

}

