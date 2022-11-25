package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;

import Domain.UserVO;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns= {"/todo.jsp", "/clock.jsp" , "/profile.jsp", "/ranking.jsp"})
public class LoginFilter extends HttpFilter implements Filter {

    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("LoginFilter : Start " );
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if((UserVO)request.getAttribute("userVO") == null) {
			System.out.println("로그인해야함" );
			httpResponse.sendRedirect("/webmodoro/login.jsp");
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
