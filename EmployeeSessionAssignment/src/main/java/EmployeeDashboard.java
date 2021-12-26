

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeDashboard
 */
@WebServlet("/employee-dashboard")
public class EmployeeDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Fetching values from login form.
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
        
		out.println( "Welcome: " + username );
		
        //creating a new hidden form field
       out.println("<form action='display-details' method='post'>");
       out.println("<input type='hidden' name='usernameHidden' value='" + username +"'>");
       out.println("<input type='hidden' name='passwordHidden' value='" + password +"'>");
       out.println("<input type='submit' value='submit' >");
       out.println("</form></body></html>");
       out.println("<script>document.forms[0].submit();</script>");
     
		
	}

}
