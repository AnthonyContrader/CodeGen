package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.model.Project;

import it.contrader.dto.EntityCustomerDTO;
import it.contrader.service.EntityCustomerService;

@Controller
@RequestMapping("/entityCustomer")
public class EntityCustomerController {

	@Autowired
	private EntityCustomerService service;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "entityCustomers";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "entityCustomers";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatentityCustomer";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			 @RequestParam("project")Project project ) {

		EntityCustomerDTO dto = new EntityCustomerDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setProject(project);
		service.update(dto);
		setAll(request);
		return "entityCustomers";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("project") Project project ) {
		EntityCustomerDTO dto = new EntityCustomerDTO();
		dto.setName(name);
		dto.setProject(project);
		service.insert(dto);
		setAll(request);
		return "entityCustomers";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readentityCustomer";
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

