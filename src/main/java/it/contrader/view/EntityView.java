package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.EntityDTO;
import it.contrader.main.MainDispatcher;


	/*
	 * 
	 * @author Selenia
	 *
	 * 
	 */
	public class EntityView extends AbstractView {

		private Request request;
		private String choice;

		public  EntityView () {
			
		}

		
		@Override
		public void showResults(Request request) {
			if (request != null) {
				System.out.println("\n------------------- Gestione entità ----------------\n");
				System.out.println("ID\tName");
				System.out.println("----------------------------------------------------\n");
				
				@SuppressWarnings("unchecked")
				List<EntityDTO> entities = (List<EntityDTO>) request.get("entities");
				for (EntityDTO e: entities)
					System.out.println(e);
				System.out.println();
			}
		}

		
		@Override
		public void showOptions() {
			System.out.println("          Scegli l'operazione da effettuare:");
			System.out.println("[1]Leggi [2]Inserisci [3]Modifica [4]Cancella [5]Back [6]Esci");

			this.choice = getInput();

			
		}
		
		
		@Override
		public void submit() {
			request = new Request();
			request.put("choice", choice);
			request.put("mode", "GETCHOICE");
			MainDispatcher.getInstance().callAction("Entity", "doControl", this.request);
		}

	}

