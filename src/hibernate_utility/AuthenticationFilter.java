package hibernate_utility;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
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
		// pass the request along the filter chain
		HttpServletRequest httpRequst=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		HttpSession session=httpRequst.getSession();
		String uri=httpRequst.getRequestURI();
		if((session==null || session.getAttribute("email")==null)  && httpRequst.getRequestURI().endsWith("message.jsp")){
			RequestDispatcher rd=	httpRequst.getRequestDispatcher("message.jsp");
			rd.forward(httpRequst, httpResponse);
		}
		else if((session==null || session.getAttribute("email")==null)  && httpRequst.getRequestURI().endsWith("changepassword.jsp")){
			RequestDispatcher rd=	httpRequst.getRequestDispatcher("changepassword.jsp");
			rd.forward(httpRequst, httpResponse);
		}
		else if((session==null || session.getAttribute("email")==null)  && httpRequst.getRequestURI().endsWith("forgotpassword.jsp")){
			RequestDispatcher rd=	httpRequst.getRequestDispatcher("forgotpassword.jsp");
			rd.forward(httpRequst, httpResponse);
		}
		else if((session==null || session.getAttribute("email")==null)  && httpRequst.getRequestURI().endsWith("registered.jsp")) {
			RequestDispatcher rd=	httpRequst.getRequestDispatcher("registered.jsp");
			rd.forward(httpRequst, httpResponse);
		}
		else if((session==null || session.getAttribute("email")==null)  && httpRequst.getRequestURI().endsWith(".jsp")) {
			RequestDispatcher rd=	httpRequst.getRequestDispatcher("login.jsp");
			rd.forward(httpRequst, httpResponse);
		}
		else if(session.getAttribute("email")!=null && (uri.endsWith("login.jsp") || uri.endsWith("registered.jsp") || uri.endsWith("forgotpassword.jsp")))
		{
			RequestDispatcher rd=	httpRequst.getRequestDispatcher("index.jsp");
			rd.forward(httpRequst, httpResponse);
		}else {
			chain.doFilter(httpRequst, httpResponse);
			
		}
			

		}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
