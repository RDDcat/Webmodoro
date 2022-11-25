package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.TaskVO;
import Domain.UserVO;
import Service.TaskService;

/**
 * Servlet implementation class LoadTaskServlet
 */
@WebServlet("/LoadTaskServlet")
public class LoadTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskService taskService = new TaskService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		// 미해결 할일 로드
		List<TaskVO> taskList = new ArrayList<TaskVO>();
		
		// 유저아이디 필요	
		UserVO userVO = (UserVO)request.getAttribute("userVO");
		taskService.loadALLTask(userVO.getUserId());
		
		// 리턴
		request.setAttribute("task", taskList);
		
		RequestDispatcher view = request.getRequestDispatcher("todo.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
