package org.o7planning.tutorial.recaptcha.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest req,HttpServletResponse resp) {
		
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		System.out.println("iniciando app login");
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		System.out.println("dopost LoginServlet");
		
		this.doGet(req, resp);
	}

}
