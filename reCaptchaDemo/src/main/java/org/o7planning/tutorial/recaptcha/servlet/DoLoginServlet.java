package org.o7planning.tutorial.recaptcha.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.tutorial.recaptcha.VerifyUtils;

@WebServlet(urlPatterns = "/doLogin")
public class DoLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");	
	boolean valid = true;
    String errorString = null;
    
    System.out.println("doGet DoLoginServlet.class");
    
    if (!"tom".equals(userName) || !"tom001".equals(password)) {
        valid = false;
        errorString = "UserName or Password invalid!";
    }
    
    if (valid) {
    	 
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");

        System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);

        // Verify CAPTCHA.
        valid = VerifyUtils.verify(gRecaptchaResponse);
        
       if (!valid) {
            errorString = "Captcha invalid!";
        }
    }
    
    if (!valid) {
    	System.out.println("actualiza loginView si datos de aut son incorrectos o catpcha es invalido");
        request.setAttribute("errorString", errorString);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
       
        dispatcher.forward(request, response);
        return;
    } else {
        request.getSession().setAttribute("loginedUser", userName);
        // Redirect to /userInfo
        System.out.println("Redirect to /userInfo: "+request.getContextPath()+"/userInfo");
        response.sendRedirect(request.getContextPath()+"/userInfo");
    }
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("doPost DoLoginServlet.class");
       this.doGet(req, resp);
    }

}
