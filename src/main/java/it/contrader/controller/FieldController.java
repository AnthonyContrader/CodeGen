package it.contrader.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.FieldDTO;
import it.contrader.dto.LogDTO;
import it.contrader.model.EntityOwner;
import it.contrader.service.EntityOwnerService;
import it.contrader.service.FieldService;
import it.contrader.service.LogService;


@Controller
@RequestMapping("/field")
public class FieldController {

	@Autowired
	private FieldService service;
	
	@Autowired
	private EntityOwnerService serviceEntity;
	
	@Autowired
	private LogService serviceLog;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		InsertLOG(request,"Show Field"); 
		return "fields";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		InsertLOG(request,"Delete Field"); 
		return "fields";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		setAll( request);
		
		return "updatefield";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("entityowner") EntityOwner entityowner,
			@RequestParam("name") String name,  @RequestParam("type") String type ,  @RequestParam("lenght") Long lenght,@RequestParam("id") Long id  ) {

		FieldDTO dto = new FieldDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setType(type);
		dto.setLenght(lenght);
		dto.setEntityowner(entityowner);
		service.update(dto);
		setAll(request);
		InsertLOG(request,"Update Field"); 
		return "fields";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("entityowner") EntityOwner entityowner,
			@RequestParam("name") String name,  @RequestParam("type") String type ,  @RequestParam("lenght") Long lenght ) {
		FieldDTO dto = new FieldDTO();
		dto.setName(name);
		dto.setType(type);
		dto.setLenght(lenght);
		dto.setEntityowner(entityowner);
		service.insert(dto);
		setAll(request);
		InsertLOG(request,"Insert Field"); 
		return "fields";
	}
	
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		InsertLOG(request,"Read Field"); 
		return "readfield";
		
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listEntity", serviceEntity.getAll());
	}
	
	public void InsertLOG(HttpServletRequest request,String mode) {
		String temp = ""+request.getSession().getAttribute("user");				
		temp = (""+request.getSession().getAttribute("user")).replace("UserDTO(","").replace(")", "");
		String[] User_temp = temp.split(",");
		
		String USER=User_temp[1].replace("username=","");
		Date date = new Date();
		
		
		serviceLog.insert(new LogDTO(USER,mode,date));
	}

	
}
