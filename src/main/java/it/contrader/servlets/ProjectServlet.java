package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.LogDTO;
import it.contrader.dto.ProjectDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.LogService;
import it.contrader.service.ProjectService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ProjectDTO> service = new ProjectService();
		List<ProjectDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<LogDTO> servicelog = new LogService(); LogDTO dtoLog;
		Service<ProjectDTO> service = new ProjectService();
		String mode = request.getParameter("mode");
		ProjectDTO dto;
		int id;
		boolean ans;

		HttpSession session = request.getSession();
		UserDTO dtoUser = (UserDTO) session.getAttribute("user");
		dtoLog = new LogDTO(mode.replaceAll("project", "").concat(" - PROJECT"),dtoUser.getUsername(), "");	
		ans = servicelog.insert(dtoLog);
		request.setAttribute("ans", ans);
		
		switch (mode.toUpperCase()) {

		case "PROJECTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/project/readproject.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/project/updateproject.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String description = request.getParameter("description").toString();
			String shippingdate = request.getParameter("shippingdate").toString();
			dto = new ProjectDTO (name,description,shippingdate);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			description = request.getParameter("description");
			shippingdate = request.getParameter("shippingdate");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ProjectDTO (id,name,description,shippingdate);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;
		}
	}
}