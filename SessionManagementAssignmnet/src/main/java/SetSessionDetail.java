

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetSessionDetail
 */
@WebServlet("/session-set")
public class SetSessionDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetSessionDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting session parameters with values received from form. 
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		HttpSession session = request.getSession();
        session.setAttribute("username",  username);
		session.setAttribute("age",  age); 
		session.setAttribute("password",  password); 
		session.setAttribute("email",  email);
		session.setAttribute("country",  country);
		
		//Redirect to another servlet
		response.sendRedirect("show-session-details");
		
	}

}
