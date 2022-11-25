package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain.TaskVO;
import Service.TaskService;

/**
 * Servlet implementation class SaveTaskServlet
 */
@WebServlet("/SaveTaskServlet")
public class SaveTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskService taskService = new TaskService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SaveTaskServlet 의 Get");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SaveTaskServlet 의 Post");
		
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		long userId = (long)session.getAttribute("userId");
		
		String taskDescribtion = (String)request.getParameter("taskDescribtion");
		TaskVO taskVO = new TaskVO();
		taskVO.setTaskDescribtion(taskDescribtion);

		taskService.saveTask(userId, taskVO);
		
	}

}
