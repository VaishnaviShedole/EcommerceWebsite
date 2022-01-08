package com.flipkart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cart")
public class Cart extends HttpServlet{
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session1 = req.getSession(false);
		if (session1.getAttribute("name") != null)
		{
			String email=(String)session1.getAttribute("mail");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart","root","techouts");
			
			PreparedStatement st = con.prepareStatement("select * from cart;"); 
			ResultSet rs = st.executeQuery();
	        List<Product>  li = new ArrayList<Product>();
	        while(rs.next())
	        {
	        	Product product = new Product();
	          	product.setId(rs.getInt("id"));
	        	product.setName(rs.getString("name"));
	        	product.setPrice(rs.getDouble("price"));
	        	product.setImage(rs.getString("image"));
	        	li.add(product);
	        }
	        req.setAttribute("productList",li);
	        RequestDispatcher rd= req.getRequestDispatcher("Cart.jsp");
	        rd.forward(req , res);
	        con.close();
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