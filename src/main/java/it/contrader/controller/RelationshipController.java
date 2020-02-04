package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.EntityOwnerDTO;
import it.contrader.dto.EntityCustomerDTO;
import it.contrader.dto.EntityOwnerService;
import it.contrader.dto.EntityCustomerService;
import it.contrader.dto.RelationshipDTO;
import it.contrader.service.RelationshipService;

@Controller
@RequestMapping("/relationship")
public class RelationshipController {

	@Autowired
	private RelationshipService service;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "relationships";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "relationships";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updaterelationships";
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
		return "relationships";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("entityowner") EntityOwner entityowner,
			@RequestParam("entitycustomer") EntityCustomer entitycustomer) {
		RelationshipDTO dto = new RelationshipDTO();
		dto.setEntityowner(entityowner);
		dto.setEntitycustomer(entitycustomer);
		service.insert(dto);
		setAll(request);
		return "relationships";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readrelationship";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
