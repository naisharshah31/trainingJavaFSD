

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeFetch
 */
@WebServlet("/display-details")
public class EmployeeFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeFetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting values from hidden form fields
		String username = request.getParameter("usernameHidden");
        String password = request.getParameter("passwordHidden");
		
        //Setting session with username and password
		HttpSession session=request.getSession();  
		session.setAttribute("username",  username);
		session.setAttribute("password",  password); 
		
		//Displaying username and password
		PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        //Checking whether hidden form field values are received properly or not. 
        if ( username == null && password == null ) {
            out.println("No Username and Password was found in hidden form field.<br>");
        } else {
            out.println("Username: " + username + "<br> <br>");
            out.println("Password: " + password + "<br> <br>");
            
            //For understanding
            out.println("Session Set!" + session);
            
        }
        out.println("</body></html>");

	}

}
