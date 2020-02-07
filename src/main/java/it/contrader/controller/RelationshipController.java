package it.contrader.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.RelationshipDTO;
import it.contrader.model.EntityCustomer;
import it.contrader.model.EntityOwner;
import it.contrader.dto.LogDTO;
import it.contrader.service.EntityOwnerService;
import it.contrader.service.RelationshipService;
import it.contrader.service.EntityCustomerService;
import it.contrader.service.LogService;

@Controller
@RequestMapping("/relationship")
public class RelationshipController {

	@Autowired
	private RelationshipService service;
	
	@Autowired
	private EntityOwnerService serviceEntityo;
	
	@Autowired
	private EntityCustomerService serviceEntityc;
	
	@Autowired
	private LogService serviceLog;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		InsertLOG(request,"Show Relationship"); 
		return "relationships";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		InsertLOG(request,"Delete Relationship"); 
		return "relationships";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updaterelationship";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("entityowner") EntityOwner entityowner,
			@RequestParam("entitycustomer") EntityCustomer entitycustomer) {

		RelationshipDTO dto = new RelationshipDTO();
		dto.setId(id);
		dto.setEntityowner(entityowner);
		dto.setEntitycustomer(entitycustomer);
		service.update(dto);
		setAll(request);
		InsertLOG(request,"Update Relationship");
		return "relationships";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("entityowner") EntityOwner entityowner,
			@RequestParam("entitycustomer") EntityCustomer entitycustomer) {
		RelationshipDTO dto = new RelationshipDTO();
		dto.setEntityowner(entityowner);
		dto.setEntitycustomer(entitycustomer);
		service.insert(dto);
		setAll(request);
		InsertLOG(request,"Insert Relationship"); 
		return "relationships";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		InsertLOG(request,"Read Relationship"); 
		return "readrelationship";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listEntityo", serviceEntityo.getAll());
		request.getSession().setAttribute("listEntityc", serviceEntityc.getAll());
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
