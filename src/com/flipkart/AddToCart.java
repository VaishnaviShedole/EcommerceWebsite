package com.flipkart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet
{
public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException
{
	HttpSession session1 = req.getSession(false);
	if (session1.getAttribute("name") != null)
	{
	String email=(String)session1.getAttribute("mail");
	   try
	   {
		int id=Integer.parseInt(req.getParameter("id"));
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart","root","techouts");
		
		String s = "select * from product where id=?";
		PreparedStatement st = con.prepareStatement(s);
		st.setInt(1,id);
		ResultSet rs = st.executeQuery();
		int id1 = 0;
		String name=null;
		String image=null;
		String category=null;
		double price=0.0;
        while(rs.next())       
        {
           	id1=rs.getInt("id");
        	name=rs.getString("name");
        	price=rs.getDouble("price");
        	image=rs.getString("image");
        	category=rs.getString("category");
        }

        String query = "insert into cart values(?,?,?,?,?);";
        PreparedStatement st1 = con.prepareStatement(query);
        st1.setInt(1 , id1);
    	st1.setString(2 , name);
    	st1.setDouble(3 , price);
    	st1.setString(4 , image);
    	st1.setString(5 , email);
    	st1.executeUpdate();
    	con.close();
    	
     	RequestDispatcher rd = req.getRequestDispatcher("AddToCart.jsp");
       	rd.forward(req, res);
  	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}   
	   else
		{
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
 
}
}
