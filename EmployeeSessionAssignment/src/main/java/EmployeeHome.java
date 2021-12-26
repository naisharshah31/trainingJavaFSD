

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeHome
 */
@WebServlet("/employee-home")
public class EmployeeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeHome() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		String city = request.getParameter("city");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		
		
		
		//Displaying username and password
		PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Username: " + username + "<br> <br>");
        out.println("Age: " + age + "<br> <br>");
        out.println("city: " + city+ "<br> <br>");
        out.println("Gender: " + gender+ "<br> <br>");
        out.println("Email: " + email + "<br> <br>");
        
        HttpSession session = request.getSession();
        session.setAttribute("username",  username);
		session.setAttribute("password",  age); 
		session.setAttribute("city",  city);
		session.setAttribute("gender",  gender); 
		session.setAttribute("email",  email);
		
		
		out.println("Creation Time: " +  session.getCreationTime() + "<br> <br>");
		out.println("getID(): " +  session.getId() + "<br> <br>");
		out.println("isNew() : " +  session.isNew() + "<br> <br>");
		    
        
        out.println("</body></html>");
	}

}
