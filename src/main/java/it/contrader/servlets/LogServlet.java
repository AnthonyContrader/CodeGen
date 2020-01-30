package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UserDTO;
import it.contrader.dto.LogDTO;
import it.contrader.service.Service;
import it.contrader.service.UserService;
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
	public void getUser(HttpServletRequest request) {
		Service<UserDTO> serviceEntity = new UserService();
		List<UserDTO>listDTO = serviceEntity.getAll();
		request.setAttribute("listUser", listDTO);
	}
	public void getLogUser(HttpServletRequest request) {
		HttpSession session = request.getSession(); 
		UserDTO dtoUser = (UserDTO) session.getAttribute("user");
		
		Service<LogDTO> serviceLog = new LogService();		
		List<LogDTO>listDTO = ((LogService) serviceLog).readByUsername(dtoUser.getUsername());
		request.setAttribute("listLogUser", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<LogDTO> service = new LogService();
		String mode = request.getParameter("mode");
		LogDTO dto;
		boolean ans;
	
		getLogUser(request);
		
		
		switch (mode.toUpperCase()) {

			case "LOGLIST":
				updateList(request);
				getUser(request);
				getServletContext().getRequestDispatcher("/log/logmanager.jsp").forward(request, response);
				break;
				
			case "INSERT":
				String action = request.getParameter("action").toString();
				String user = (request.getParameter("user").toString());
				
				dto = new LogDTO (action,user,"");
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				break;
				


		}
	}
}