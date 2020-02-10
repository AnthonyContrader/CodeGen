package it.contrader.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ProjectDTO;
import it.contrader.service.ProjectService;
import it.contrader.dto.LogDTO;
import it.contrader.service.LogService;

@Controller
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	@Autowired
	private LogService serviceLog;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		InsertLOG(request,"Show Project"); 
		return "projects";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		InsertLOG(request,"Delete Project"); 
		return "projects";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateproject";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("shippingdate") String shippingdate) {

		ProjectDTO dto = new ProjectDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setDescription(description);
		dto.setShippingdate(shippingdate);
		service.update(dto);
		setAll(request);
		InsertLOG(request,"Update Project"); 
		return "projects";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("shippingdate") String shippingdate) {
		ProjectDTO dto = new ProjectDTO();
		dto.setName(name);
		dto.setDescription(description);
		dto.setShippingdate(shippingdate);
		service.insert(dto);
		setAll(request);
		InsertLOG(request,"Insert Project"); 
		return "projects";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		InsertLOG(request,"Read Project"); 
		return "readproject";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
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
