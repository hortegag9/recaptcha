package org.o7planning.tutorial.recaptcha.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/userInfo")
public class UserInfoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 System.out.println("doGet UserInfoServlet.class");
	 if (req.getSession().getAttribute("loginedUser") == null) {
	            resp.sendRedirect(req.getContextPath() + "/login");
	            return;
	      }
		 
	RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");

    dispatcher.forward(req, resp);
    
  }
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("doPost UserInfoServlet.class");
	   this.doGet(req, resp);
	 
	 }

}
