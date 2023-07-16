package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("adminRoles");
		//request.getSession().invalidate();
		request.getSession().setAttribute("adminFilter", false);
		request.getSession().setAttribute("userFilter", false);
		request.getSession().removeAttribute("nome");
		request.getSession().removeAttribute("cognome");
		request.getSession().removeAttribute("email");
		request.getSession().removeAttribute("dataNascita");
		
		String redirectedPage = "/Home.jsp";
		response.sendRedirect(request.getContextPath() + redirectedPage);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
