package it.contrader.view.relationship;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class RelationshipUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String entity1;
	private String entity2;
	private final String mode = "UPDATE";

	public RelationshipUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Relationship", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi della relazione da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della relazione:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci la prima entità relazionale:");
			entity1 = getInput();
			System.out.println("Inserisci la seconda entità relazionale:");
			entity2 = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("entity1", entity1);
		request.put("entity2", entity2);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Relationship", "doControl", request);
	}

}
