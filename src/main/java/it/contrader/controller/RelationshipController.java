package it.contrader.controller;

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
import it.contrader.service.EntityOwnerService;
import it.contrader.service.RelationshipService;
import it.contrader.service.EntityCustomerService;

@Controller
@RequestMapping("/relationship")
public class RelationshipController {

	@Autowired
	private RelationshipService service;
	
	@Autowired
	private EntityOwnerService serviceEntityo;
	
	@Autowired
	private EntityCustomerService serviceEntityc;

	
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
	public String insert(HttpServletRequest request, @RequestParam("entityowner") EntityOwner entityowner,
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
		request.getSession().setAttribute("listEntityo", serviceEntityo.getAll());
		request.getSession().setAttribute("listEntityc", serviceEntityc.getAll());
	}
}
