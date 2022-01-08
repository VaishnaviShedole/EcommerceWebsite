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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PLP_page")
public class PLP_page extends HttpServlet{
public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
{
	
	PrintWriter pw = res.getWriter();
	try
	{
		String category=req.getParameter("category");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart","root","techouts");
        PreparedStatement st = con.prepareStatement("select * from product where category=?"); 
        st.setString(1,category);
        ResultSet rs = st.executeQuery();
        List<Product>  li = new ArrayList<Product>();
        while(rs.next())
        {
        	Product product = new Product();
          	product.setId(rs.getInt("id"));
        	product.setName(rs.getString("name"));
        	product.setPrice(rs.getDouble("price"));    
        	product.setDescription(rs.getString("description"));
        	product.setImage(rs.getString("image"));
        	product.setCategory(rs.getString("category"));
        	li.add(product);
        }
               
        req.setAttribute("productList",li);
        RequestDispatcher rd = req.getRequestDispatcher("/PLP_page.jsp");
        rd.forward(req,res);
        con.close();
	}

	catch(Exception e)
	{
		System.out.println(e);
	}

}
}
