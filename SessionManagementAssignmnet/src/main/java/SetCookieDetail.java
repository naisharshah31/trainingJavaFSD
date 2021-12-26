

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieDetail
 */
@WebServlet("/set-cookie")
public class SetCookieDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookieDetail() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        Cookie usernameCookie = new Cookie("username",username);
        Cookie passwordCookie = new Cookie("password",password);
        
        request.setAttribute("usernameFromServlet", username);
		request.setAttribute("passwordFromServlet", password);
		response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
		
        
        response.sendRedirect("show-cookie-details");
        
	}

}
