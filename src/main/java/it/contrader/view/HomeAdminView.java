/**
 * Manage a Business Owner view
 */

package it.contrader.view;


/**
 * Per Ulteriori dettagli vedi Guida sez 9 View.
 * Per la descrizione dei metodi vedi l'interfaccia View in questo pacchetto.
 */
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

    private String choice;
    
	private Request request;

	/**
	 * Se la request non è nulla mostra un messaggio di benvenuto
	 */
    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\nCiao! " +request.get("username").toString().toUpperCase() + "\nBenvenuto in CodeGen, il tuo generatore di codice personale !! " + "\n");
    	}
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("\n------------------------MENU---------------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println("[1]Utenti [2]Entità [3]Campi [4]Relazioni [5]Esci");
        System.out.println("\n_________________________________________________\n");
        //getInput() è definito in AbstractView.
        choice = this.getInput();
    }

    /**
     * Impacchetta una request (in base alla scelta sarà diversa) che invia ai controller tramite il
     * Dispatcher
     */
    public void submit() {    
    	//crea una nuova Request (vedi classe Request)
    	request = new Request();
        switch (choice) {
        case "1":
        	this.request.put("mode", "USERLIST");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
        	
        case "2":
        	this.request.put("mode", "ENTITYLIST");
        	MainDispatcher.getInstance().callAction("Entity", "doControl", request);
        	break;
        	
        case "3":
        	this.request.put("mode", "FIELDLIST");
        	MainDispatcher.getInstance().callAction("Field", "doControl", request);
        	break;
        	
        case "4":
        	this.request.put("mode", "RELATIONSHIPLIST");
        	MainDispatcher.getInstance().callAction("Relationship", "doControl", request);
        	break;
        	
        case "5":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
        	
        default:        	
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
        	
        	
        }
    }
}
