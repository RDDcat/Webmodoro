package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.TaskService;

/**
 * Servlet implementation class DoneTaskServlet
 */
@WebServlet("/DoneTaskServlet")
public class DoneTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskService taskService = new TaskService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoneTaskServlet 의 Get");
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoneTaskServlet 의 Post");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
