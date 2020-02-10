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

import it.contrader.dto.LogDTO;
import it.contrader.service.LogService;
import it.contrader.service.UserService;

@Controller
@RequestMapping("/log")
@CrossOrigin(origins = "http://localhost:4200")
public class LogController {

	@Autowired
	private LogService service;
	@Autowired
	private UserService serviceUser;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "logs";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "logs";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatelog";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("user") String user,
			@RequestParam("action") String action, @RequestParam("moment") Date moment) {

		LogDTO dto = new LogDTO();
		dto.setId(id);
		dto.setUser(user);
		dto.setAction(action);
		dto.setMoment(moment);
		service.update(dto);
		setAll(request);
		return "logs";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("user") String user,
			@RequestParam("action") String action, @RequestParam("moment") Date moment) {
		LogDTO dto = new LogDTO();
		dto.setUser(user);
		dto.setAction(action);
		//dto.setMoment(moment);
		service.insert(dto);
		setAll(request);
		return "logs";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readlog";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listLogUser", serviceUser.getAll());
		
	}
}
