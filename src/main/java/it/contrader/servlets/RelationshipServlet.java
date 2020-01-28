package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.RelationshipDTO;
import it.contrader.service.Service;
import it.contrader.service.RelationshipService;

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
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<RelationshipDTO> service = new RelationshipService();
		String mode = request.getParameter("mode");
		RelationshipDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "RELATIONSHIPLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/relationship/relationshipmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/relationship/readrelationship.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/relationship/updaterelationship.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String entity1 = request.getParameter("entity1").toString();
			String entity2 = request.getParameter("entity2").toString();
			dto = new RelationshipDTO (entity1,entity2);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/relationship/relationshipmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			entity1 = request.getParameter("entity1");
			entity2 = request.getParameter("entity2");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new RelationshipDTO (id,entity1, entity2);
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