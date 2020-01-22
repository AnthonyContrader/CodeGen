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
				List<EntityDTO> entity = (List<EntityDTO>) request.get("entity");
				for (EntityDTO e: entity)
					System.out.println(e);
				System.out.println();
			}
		}

		
		@Override
		public void showOptions() {
			System.out.println("          Scegli l'operazione da effettuare:");
			System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

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

