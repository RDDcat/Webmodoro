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
import javax.servlet.http.HttpSession;

import Domain.TaskVO;
import Domain.UserVO;
import Service.TaskService;
import Service.UserService;

/**
 * Servlet implementation class LoadClockServlet
 */
@WebServlet("/LoadClockServlet")
public class LoadClockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TaskService taskService = new TaskService();
	private UserService userService = new UserService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		List<TaskVO> taskList = new ArrayList<TaskVO>();
		
		// 유저 아이디로 유저 정보 가져오기
		UserVO userVO = new UserVO();
		if((UserVO)request.getAttribute("userVO") == null) {
			System.out.println((long)session.getAttribute("userId"));
			userVO = userService.getUserVO((long)session.getAttribute("userId"));
			session.setAttribute("userVO", userVO);
		}
		// 유저아이디 필요	
		userVO = (UserVO)session.getAttribute("userVO");
		taskList = taskService.loadALLTask(userVO.getUserId());
		
		// 리턴
		request.setAttribute("tasks", taskList);
		
		RequestDispatcher view = request.getRequestDispatcher("clock.jsp");
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
