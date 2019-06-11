package com.ibm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/enroll")
public class Enroll extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n=0;
		int i=Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceassignmentsdb", "root", "");	
		Statement stmt = dbCon.createStatement();
		String qry="update training_master set availableSeats=availableSeats-1 where trainingID=?";
		PreparedStatement pst= dbCon.prepareStatement(qry);
		pst.setInt(1, i);
		pst.executeUpdate();
		qry="select availableSeats from training_master where trainingID='" +i+ "'";
		ResultSet rs=stmt.executeQuery(qry);
		
		while(rs.next()) {
			n= rs.getInt("availableSeats");
		}
		//response.sendRedirect("index.jsp");
		//out.println(i);
		out.print(n);
	}catch (SQLException | ClassNotFoundException e) {
        System.out.println(e);		
	}
	}


}
