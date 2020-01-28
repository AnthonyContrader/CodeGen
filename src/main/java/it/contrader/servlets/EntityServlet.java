package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.EntityDTO;
import it.contrader.service.Service;
import it.contrader.service.EntityService;

public class EntityServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EntityServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<EntityDTO> service = new EntityService();
		List<EntityDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<EntityDTO> service = new EntityService();
		String mode = request.getParameter("mode");
		EntityDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "ENTITYLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/entity/entitymanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/entity/readentity.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/entity/updateentity.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String nome = request.getParameter("nome").toString();
			
			dto = new EntityDTO (nome);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/entity/entitymanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			nome = request.getParameter("nome");
			
			id = Integer.parseInt(request.getParameter("id"));
			dto = new EntityDTO (id,nome);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/entity/entitymanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/entity/entitymanager.jsp").forward(request, response);
			break;
		}
	}

}
