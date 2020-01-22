package it.contrader.view.entity;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EntityInsertView extends AbstractView{
	private Request request;

	private String name;
	

	private final String mode = "INSERT";

	public EntityInsertView() {
	}
	
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Entity", null);
		}
	}

	
	@Override
	public void showOptions() {
			System.out.println("Inserisci name dell'entità:");
			name = getInput();
			
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Entity", "doControl", request);
	}
}



 


