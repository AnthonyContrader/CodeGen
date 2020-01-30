package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.EntityDTO;
import it.contrader.dto.RelationshipDTO;
import it.contrader.dto.LogDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.EntityService;
import it.contrader.service.RelationshipService;
import it.contrader.service.LogService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class RelationshipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RelationshipServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<RelationshipDTO> service = new RelationshipService();
		List<RelationshipDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
		updateEntity(request);
	}
	
	public void updateEntity(HttpServletRequest request) {
		Service<EntityDTO> service = new EntityService();
		List<EntityDTO>listDTO = service.getAll();
		request.setAttribute("listP", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<LogDTO> servicelog = new LogService(); LogDTO dtoLog;
		Service<RelationshipDTO> service = new RelationshipService();
		String mode = request.getParameter("mode");
		RelationshipDTO dto;
		int id;
		boolean ans;
		
		HttpSession session = request.getSession(); 
		UserDTO dtoUser = (UserDTO) session.getAttribute("user");
		dtoLog = new LogDTO(mode,dtoUser.getUsername(), "");
		
		ans = servicelog.insert(dtoLog);
		request.setAttribute("ans", ans);

		switch (mode.toUpperCase()) {

		case "RELATIONSHIPLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/relationship/relationshipmanager.jsp").forward(request, response);
			break;

		case "READ":
			
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			updateEntity(request);
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/relationship/readrelationship.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/relationship/updaterelationship.jsp").forward(request, response);
			
			break;

		case "INSERT":
			int entity1 = Integer.parseInt(request.getParameter("selectentity1").toString());
			int entity2 = Integer.parseInt(request.getParameter("selectentity2").toString());
			dto = new RelationshipDTO (entity1,entity2);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/relationship/relationshipmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			entity1 = Integer.parseInt(request.getParameter("selectentity1").toString());
			entity2 = Integer.parseInt(request.getParameter("selectentity2").toString());
			id = Integer.parseInt(request.getParameter("id"));
			dto = new RelationshipDTO (id,entity1,entity2);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/relationship/relationshipmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/relationship/relationshipmanager.jsp").forward(request, response);
			break;
		}
	}
}