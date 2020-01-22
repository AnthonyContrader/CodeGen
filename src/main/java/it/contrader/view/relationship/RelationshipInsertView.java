package it.contrader.view.relationship;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class RelationshipInsertView extends AbstractView{
	private Request request;

	private String entity1;
	private String entity2;
	private final String mode = "INSERT";

	public RelationshipInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Relationship", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi della relazione da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci prima entità relazionale:");
			entity1 = getInput();
			System.out.println("Inserisci seconda entità relazionale:");
			entity2 = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("entity1", entity1);
		request.put("entity2", entity2);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Relationship", "doControl", request);
	}


}
