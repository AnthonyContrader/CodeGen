package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.LogDTO;
import it.contrader.service.Service;
import it.contrader.service.LogService;

/**
 * 
 * @author Depy
 *
 */
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<LogDTO> service = new LogService();
		List<LogDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<LogDTO> service = new LogService();
		String mode = request.getParameter("mode");
		LogDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "USERLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/log/logmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/log/readlog.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/log/updatelog.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String action = request.getParameter("action").toString();
			int iduser = Integer.parseInt(request.getParameter("iduser"));
			String date = request.getParameter("date").toString();
			dto = new LogDTO (action,iduser,date);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/log/logmanager.jsp").forward(request, response);
			break;
			/*
		case "UPDATE":
			action = request.getParameter("action");
			iduser = Integer.parseInt(request.getParameter("iduser"));
			date = request.getParameter("date");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new LogDTO (id,action, iduser, date);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/log/logmanager.jsp").forward(request, response);
			break;
			*/

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/log/logmanager.jsp").forward(request, response);
			break;
		}
	}
}