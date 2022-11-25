package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Domain.TaskVO;
import Persist.TaskDAO;
import Service.TaskService;

/**
 * Servlet implementation class RestServlet
 */
@WebServlet("/RestServlet")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); response. setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cmdReq; 
		cmdReq = request.getParameter("cmd"); 
		if(cmdReq == null) return;
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")==null) return;
		
		TaskService service = new TaskService();
		
		if(cmdReq.equals("list")) { 
			List<TaskVO> tasklist = service.loadALLTask((long)session.getAttribute("userId"));
			JSONObject json = new JSONObject(tasklist);
			out.print(json);		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
