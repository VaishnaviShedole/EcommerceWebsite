package com.flipkart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	
public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
{
	res.getContentType();
	PrintWriter pw = res.getWriter();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart","root","techouts");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
	
		HttpSession session = req.getSession();
		session.setAttribute("mail",email);
		
		String s1 = "select name from registration where email='"+email+"';";
		PreparedStatement st =con.prepareStatement(s1);
		ResultSet set = st.executeQuery();
		String name=null;
		
		while(set.next())
		{
		name = set.getString("name");
		}
		session.setAttribute("name",name);


		String s = "select count(*) from registration where email='"+email+"' and password='"+password+"';";
		
		PreparedStatement ps = con.prepareStatement(s);
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while(rs.next())
		{
		count=rs.getInt(1);
		}
		
		if(count>0)
		{ 
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			req.setAttribute("msg" , "Invalid credentials");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
		pw.close();
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
