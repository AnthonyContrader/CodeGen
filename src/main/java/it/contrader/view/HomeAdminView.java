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
    	System.out.println("\nCiao! " +request.get("username").toString().toUpperCase() + " Benvenuto in CodeGen, il tuo generatore di codice personale !! " + "\n");
    	}
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println("[U]tenti [EN]tity [F]IELD [R]ELATIONSHIP [E]sci");
        //Il metodo che salva l'input nella stringa choice.
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
        case "u":
        	this.request.put("mode", "USERLIST");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
 
        case "e":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
        	
        case "en":
        	this.request.put("mode", "ENTITYLIST");
        	MainDispatcher.getInstance().callAction("Entity", "doControl", request);
        	break;
        	
        case "f":
        	this.request.put("mode", "FIELDLIST");
        	MainDispatcher.getInstance().callAction("Field", "doControl", request);
        	break;
        	
        case "r":
        	this.request.put("mode", "RELATIONSHIPLIST");
        	MainDispatcher.getInstance().callAction("Relationship", "doControl", request);
        	break;
        	
        default:
        	
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }
}
