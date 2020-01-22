package it.contrader.controller;

import java.util.List;

import it.contrader.dto.FieldDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.FieldService;

/**
 * 
 * @author Depy
 *
 */
public class FieldController implements Controller {

	private static String sub_package = "user.";
	
	private FieldService fieldService;
	public FieldController() {
		this.fieldService = new FieldService();
	}
	
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String name;
		String type;
		String entity;

		switch (mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			FieldDTO fieldDTO = fieldService.read(id);
			request.put("fields", fieldDTO);
			MainDispatcher.getInstance().callView(sub_package + "FieldRead", request);
			break;
		
		case "INSERT":
			name = request.get("name").toString();
			type = request.get("type").toString();
			entity = request.get("entity").toString();
			
			FieldDTO fieldtoinsert = new FieldDTO(name, type, entity);
			fieldService.insert(fieldtoinsert);
			
			
			request = new Request();
			request.put("mode", "mode");

			MainDispatcher.getInstance().callView(sub_package + "FieldInsert", request);
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			fieldService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "FieldDelete", request);
			break;
		
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			type = request.get("type").toString();
			entity = request.get("entity").toString();
			FieldDTO usertoupdate = new FieldDTO(name, type, entity);
			usertoupdate.setId(id);
			fieldService.update(usertoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "FieldUpdate", request);
			break;
			
		case "FIELDLIST":
			List<FieldDTO> fieldDTO1 = fieldService.getAll();
			request.put("fields", fieldDTO1);
			MainDispatcher.getInstance().callView("Field", request);
			break;
			
		case "GETCHOICE":
			switch (choice.toUpperCase()) {
			
			case "1":
				MainDispatcher.getInstance().callView(sub_package + "FieldRead", null);
				break;
				
			case "2":
				MainDispatcher.getInstance().callView(sub_package + "FieldInsert", null);
				break;
				
			case "3":
				MainDispatcher.getInstance().callView(sub_package + "FieldUpdate", null);
				break;
				
			case "4":
				MainDispatcher.getInstance().callView(sub_package + "FieldDelete", null);
				break;
				
			case "5":
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
