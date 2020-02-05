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
//import it.contrader.service.ProjectService;

@Controller
@RequestMapping("/entityowner")
public class EntityOwnerController {

	@Autowired
	private EntityOwnerService service;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "entityowners";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "entityowners";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatentityowner";
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
		return "entityowners";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("idproject") Project idproject ) {
		EntityOwnerDTO dto = new EntityOwnerDTO();
		dto.setName(name);
		dto.setIdproject(idproject);
		service.insert(dto);
		setAll(request);
		return "entityowners";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readentityowner";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		/*if(!serviceProject.getAll().isEmpty()) {
			System.out.println("\n\n\n\n\n"+serviceProject.getAll().isEmpty()+"\n\n\n\n\n");
			request.getSession().setAttribute("listProject", serviceProject.getAll());*/
		}
	}


