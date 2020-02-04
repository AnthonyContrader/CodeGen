package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.FieldDTO;
import it.contrader.service.FieldService;

@Controller
@RequestMapping("/field")
public class FieldController {

	@Autowired
	private FieldService service;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "fields";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "fields";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatfield";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("type") String type,  @RequestParam("lenght") Long lenght ) {

		FieldDTO dto = new FieldDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setType(type);
		dto.setLenght(lenght);
		service.update(dto);
		setAll(request);
		return "fields";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("type") String type,  @RequestParam("lenght") Long lenght ) {
		FieldDTO dto = new FieldDTO();
		dto.setName(name);
		dto.setType(type);
		dto.setLenght(lenght);
		service.insert(dto);
		setAll(request);
		return "fields";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
