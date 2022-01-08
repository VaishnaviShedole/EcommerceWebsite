package com.flipkart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Registration")
public class Registration extends HttpServlet{
public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
{
	res.getContentType();
	PrintWriter pw = res.getWriter();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart","root","techouts");
		String query = "insert into registration values(?,?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,req.getParameter("name"));
		st.setString(2, req.getParameter("password"));
		st.setString(3, req.getParameter("email"));
		st.executeUpdate();
		
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
	    rd.forward(req, res);
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally{
	}
}
}
