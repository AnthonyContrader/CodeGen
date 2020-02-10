package it.contrader.controller;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.LogDTO;
import it.contrader.dto.EntityOwnerDTO;
import it.contrader.model.Project;
import it.contrader.service.EntityOwnerService;
import it.contrader.service.ProjectService;
import it.contrader.service.LogService;
import it.contrader.service.EntityCustomerService;
import it.contrader.dto.EntityCustomerDTO;


@Controller
@RequestMapping("/entityowner")
public class EntityOwnerController {

	@Autowired
	private EntityOwnerService service;
	@Autowired
	private ProjectService servicep;
	@Autowired
	private EntityCustomerService servicec;
	
	@Autowired
	private LogService serviceLog;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		InsertLOG(request,"Show Entityowner"); 
		return "entityowners";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		servicec.delete(id);
		service.delete(id);
		setAll(request);
		InsertLOG(request,"Delete Entityowner"); 
		return "entityowners";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateentityowner";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			 @RequestParam("project") Project project ) {

		EntityOwnerDTO dto = new EntityOwnerDTO();
		EntityCustomerDTO dtoc = new EntityCustomerDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setProject(project);
		dtoc.setId(id);
		dtoc.setName(name);
		dtoc.setProject(project);
		service.update(dto);
		servicec.update(dtoc);
		setAll(request);
		InsertLOG(request,"Update Entityowner"); 
		return "entityowners";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("project") Project project ) {
		
		EntityOwnerDTO dto = new EntityOwnerDTO();
		EntityCustomerDTO dtoc = new EntityCustomerDTO();
		dto.setName(name);
		dto.setProject(project);
		dtoc.setName(name);
		dtoc.setProject(project);
		service.insert(dto);
		servicec.insert(dtoc);
		setAll(request);
		InsertLOG(request,"Insert Entityowner"); 
		return "entityowners";
	}


	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		InsertLOG(request,"Read  Entityowner"); 
		return "readentityowner";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listP", servicep.getAll());
		
		
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


