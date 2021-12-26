

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowSessionDetails
 */
@WebServlet("/show-session-details")
public class ShowSessionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSessionDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting values from session, which was set in SetSessionDetail Servlet and printing it.
		PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        //DOUBT: Why we pass false in getSession() method
        HttpSession session=request.getSession(false);  
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        int age = (int)session.getAttribute("age");
        String email = (String)session.getAttribute("email");
        String country = (String)session.getAttribute("country");
        
        //If all values are set properly then only display all details.
        if ( username != null && password != null && email != null && country != null  ) {
        	out.println("Username obtained from session :" + username + "<br>");
        	out.println("Password obtained from session :" + password + "<br>");
        	out.println("Age obtained from session :" + age + "<br>");
        	out.println("Email obtained from session :" + email + "<br>");
        	out.println("Country obtained from session :" + country + "<br> <br> <br>");
        	
        	//Printing other values like Creation Time(), Max time interval(), Last accessed time() of session. 
        	out.println("Creation Time(): " + new Date( session.getCreationTime()) + "<br> <br>");
    		out.println("Max time interval(): " +  session.getMaxInactiveInterval() + "<br> <br>");
    		out.println("Last accessed time(): " +  new Date(session.getLastAccessedTime()) + "<br> <br>");
    		
            
        } else {
        	
        	//If anyone of the value is not set properly then display this below message.
        	 out.println("Details was found in session.<br>");
        }
              
        
        out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
