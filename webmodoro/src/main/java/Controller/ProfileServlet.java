package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain.TaskVO;
import Domain.UserVO;
import Service.UserService;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		long userId = (long)session.getAttribute("userId");
		
		
		UserVO userVO = new UserVO();
		

		System.out.println("userId : " + userId);

		userVO = userService.getUserVO(userId);
		
		
		System.out.println("userVO : " + userVO.getUserName());

		System.out.println("userVO : " + userVO.getContact());
		
		request.setAttribute("userVO", userVO);
		
		RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
		view.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
