package com.ibm.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		String userNameFromForm = request.getParameter("userName");
		String userPassFromForm = request.getParameter("userPass");
		
		//Check whether user has entered something
		if(userNameFromForm.trim() == "") {
			out.println("You can't leave the username empty!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
			
			dispatcher.include(request, response);
		}
		else if(userNameFromForm.equalsIgnoreCase("Gargee") && userPassFromForm.equalsIgnoreCase("12345")) {
            request.getRequestDispatcher("/success").forward(request, response);			
		}
		else {
			out.println("Invalid username or password....");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
			
			dispatcher.include(request, response);
		}
	}

}
