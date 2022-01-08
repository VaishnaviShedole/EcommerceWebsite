package com.flipkart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")
public class Remove extends HttpServlet{
public void doPost(HttpServletRequest req ,HttpServletResponse res){
	try
	{
		int id = Integer.parseInt(req.getParameter("id"));
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart","root","techouts");
		String s = "delete from cart where id=?";
		PreparedStatement st = con.prepareStatement(s);
		st.setInt(1,id);
		st.executeUpdate();
	    
	    PreparedStatement st1 = con.prepareStatement("select * from cart;"); 
		ResultSet rs = st1.executeQuery();
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
}
