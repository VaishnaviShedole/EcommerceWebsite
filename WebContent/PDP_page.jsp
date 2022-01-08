<%@page import="org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.flipkart.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<header style="background-color:blue">
<table border="0" width="100%" bgcolor="blue">
<tr>
<a href="Home.jsp"><button>Home</button></a>
<form action="PLP_page" method="post"> 
<th width="25%"><button name="category" value="Fashion">Fashion</button></th>
<th width="25%"><button name="category" value="Mobiles">Mobile</button></th>
<th width="25%"><button name="category" value="HomeAppliances">HomeAppliances</button></th>
<th width="25%"><button name="category" value="Electronics">Electronics</button></th>
</form>
</tr>
</table>
</header>

<body style="background-color:lightgrey">
    <% 
    List<Product> list =(List<Product>)request.getAttribute("productList");
    for(int i=0; i<list.size(); i++) 
    {
    Product product=list.get(i);
    int id=product.getId();
    String name=product.getName();
    Double price=product.getPrice();
    String image=product.getImage();
    String description = product.getDescription();
    %>
    
    <img alt="no image" src="<%= image%>" width="200px" height="200px"> 
    <br>
    <%= "price="%>
    <%= price%>
    <br>
    <%= "Product="%>
    <%= name%>
    <br>
    <%= "description="%>
    <%= description%>
    
    <form action="buynow" method="post"> <button name="id" value="<%= id%>">Buy Now</button> </form>
    <form action="AddToCart" method="post"><button name="id" value="<%= id%>">Add to Cart</button></form>
  <%
    }
  %>  
</body>
    
<footer style="background-color:grey">
<h3>Company</h3>
<h3>Industries</h3>
<h3>About us</h3>
<h3>Contact</h3>
</footer>
    </html>
  