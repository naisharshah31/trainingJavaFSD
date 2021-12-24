package com.testing;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;  

@WebFilter( urlPatterns = {"/dashboard", "/profile"} )
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String userId = request.getParameter("userid");

        if( userId != null){
                chain.doFilter(request, response);
        } else {
        	response.getWriter().print("Blocked because value is not passed");
        }

		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
