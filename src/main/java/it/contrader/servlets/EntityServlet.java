package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.EntityDTO;
import it.contrader.dto.ProjectDTO;
import it.contrader.service.Service;
import it.contrader.service.EntityService;
import it.contrader.service.ProjectService;


public class EntityServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EntityServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<EntityDTO> service = new EntityService();
		List<EntityDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	public void getIdproject(HttpServletRequest request) {
		Service<ProjectDTO> serviceProject = new ProjectService();
		List<ProjectDTO>listDTO = serviceProject.getAll();
		request.setAttribute("listP", listDTO);
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
			getIdproject(request);
			getServletContext().getRequestDispatcher("/entity/entitymanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getIdproject(request);
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/entity/readentity.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/entity/updateentity.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			int idproject = Integer.parseInt(request.getParameter("idproject").toString());
			
			dto = new EntityDTO (name, idproject);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/entity/entitymanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			idproject = Integer.parseInt(request.getParameter("idproject"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new EntityDTO (id,name, idproject);
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
