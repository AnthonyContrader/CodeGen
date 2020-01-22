package it.contrader.controller;

import java.util.List;

import it.contrader.dto.EntityDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.EntityService;

public class EntityController implements Controller {

	
	private static String sub_package = "entity.";
	
	private EntityService entityService;
	
	public EntityController() {
		this.entityService = new EntityService();
	}
	
	
	
	
	@Override
	public void doControl(Request request) {
		
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

	
		int id;
		String name;
	
		switch (mode) {
		
	
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			EntityDTO entitiesDTO = entityService.read(id);
			request.put("entities", entitiesDTO);
			MainDispatcher.getInstance().callView(sub_package + "EntityRead", request);
			break;
		
		
		case "INSERT":
			name = request.get("name").toString();
		
			
			
			EntityDTO entitytoinsert = new EntityDTO(name);
			
			entityService.insert(entitytoinsert);
			request = new Request();
			request.put("mode", "mode");
			
			MainDispatcher.getInstance().callView(sub_package + "EntityInsert", request);
			break;
		
	
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
		
			entityService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EntityDelete", request);
			break;
		
	
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			
			EntityDTO entitytoupdate = new EntityDTO(name);
			entitytoupdate.setId(id);
			entityService.update(entitytoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "UserUpdate", request);
			break;
			
		
		case "EntityLIST":
			List<EntityDTO> entityDTO = entityService.getAll();
		
			request.put("entity", entityDTO);
			MainDispatcher.getInstance().callView("Entity", request);
			break;
			
		
		case "GETCHOICE":
					
			
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "EntityRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "EntityInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "EntityUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "EntityDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}



