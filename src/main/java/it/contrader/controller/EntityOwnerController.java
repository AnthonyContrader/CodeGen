package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.EntityOwnerDTO;
import it.contrader.model.Project;
import it.contrader.service.EntityOwnerService;

@Controller
@RequestMapping("/entityOwner")
public class EntityOwnerController {

	@Autowired
	private EntityOwnerService service;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "entityOwners";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "entityOwners";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatentityOwner";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			 @RequestParam("idproject") Project idproject ) {

		EntityOwnerDTO dto = new EntityOwnerDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setIdproject(idproject);
		service.update(dto);
		setAll(request);
		return "entityOwners";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("idproject") Project idproject ) {
		EntityOwnerDTO dto = new EntityOwnerDTO();
		dto.setName(name);
		dto.setIdproject(idproject);
		service.insert(dto);
		setAll(request);
		return "entityOwners";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readentityOwner";
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

