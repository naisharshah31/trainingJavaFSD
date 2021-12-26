

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
		PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        //DOUBT: Why we pass false in getSession() method
        HttpSession session=request.getSession(false);  
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        int age = (int)session.getAttribute("age");
        String email = (String)session.getAttribute("email");
        String country = (String)session.getAttribute("country");
        
        
        if ( username != null && password != null && email != null && country != null  ) {
        	out.println("Username obtained from session :" + username + "<br>");
        	out.println("Password obtained from session :" + password + "<br>");
        	out.println("Age obtained from session :" + age + "<br>");
        	out.println("Email obtained from session :" + email + "<br>");
        	out.println("Country obtained from session :" + country + "<br> <br> <br>");
        	
        	
        	out.println("Creation Time(): " + new Date( session.getCreationTime()) + "<br> <br>");
    		out.println("Max time interval(): " +  session.getMaxInactiveInterval() + "<br> <br>");
    		out.println("Max time interval(): " +  new Date(session.getLastAccessedTime()) + "<br> <br>");
    		
            
        } else {
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
