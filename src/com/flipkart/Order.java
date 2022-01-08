package com.flipkart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/Order1")
public class Order extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res)
		{
    HttpSession session = req.getSession(false);	
	 String email=(String)session.getAttribute("mail");
    try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart","root","techouts");
		Statement stmt = con.createStatement();
		PreparedStatement st = con.prepareStatement("select * from ordernow where email='"+email+"'"); 
		
		ResultSet rs = st.executeQuery();
        List<Product>  li = new ArrayList<Product>();
        while(rs.next())
        {
        	Product product = new Product();
          	product.setId(rs.getInt("id"));
        	product.setName(rs.getString("name"));
        	product.setPrice(rs.getDouble("price"));
        	product.setImage(rs.getString("image"));
        	product.setEmail(rs.getString("email"));
        	li.add(product);
        }
        req.setAttribute("productList",li);
        RequestDispatcher rd= req.getRequestDispatcher("order.jsp");
        rd.forward(req , res);
        con.close();
	}
    catch (Exception e) 
	{
		System.out.println(e);
	}
}
}
