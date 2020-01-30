package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.EntityDTO;
import it.contrader.dto.FieldDTO;
import it.contrader.service.Service;
import it.contrader.service.EntityService;
import it.contrader.service.FieldService;

/**
 * 
 * @author Depy
 *
 */
public class FieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FieldServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<FieldDTO> service = new FieldService();
		List<FieldDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
		getEntity( request);
	}
	
	public void getEntity(HttpServletRequest request) {
		Service<EntityDTO> serviceEntity = new EntityService();
		List<EntityDTO>listDTO = serviceEntity.getAll();
		request.setAttribute("listEntity", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<FieldDTO> service = new FieldService();
		String mode = request.getParameter("mode");
		FieldDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "FIELDLIST":
			updateList(request);			
			getServletContext().getRequestDispatcher("/field/fieldmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getEntity(request);
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/field/readfield.jsp").forward(request, response);				
			}
			
			else getServletContext().getRequestDispatcher("/field/updatefield.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String type = request.getParameter("type").toString();
			int entity = Integer.parseInt(request.getParameter("entity").toString());
			int lenght = Integer.parseInt(request.getParameter("lenght").toString());
			dto = new FieldDTO (name,type,entity,lenght);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/field/fieldmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			type = request.getParameter("type");
			entity = Integer.parseInt(request.getParameter("entity"));
			id = Integer.parseInt(request.getParameter("id"));
			lenght = Integer.parseInt(request.getParameter("lenght"));
			dto = new FieldDTO (id,name, type, entity,lenght);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/field/fieldmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/field/fieldmanager.jsp").forward(request, response);
			break;
		}
	}
}