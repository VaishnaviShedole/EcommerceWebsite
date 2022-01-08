<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.flipkart.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header style="background-color:lightblue">
<h1>My orders</h1>
<a href="Home.jsp"><button>Home</button></a>
</header>
<% 
    List<Product> list =(List<Product>)request.getAttribute("productList");
    for(int i=0; i<list.size(); i++) 
    {
    Product product=list.get(i);
    int id=product.getId();
    String name=product.getName();
    Double price=product.getPrice();
    String image=product.getImage();
    String email=product.getEmail();
    %>
    
    <img alt="no image" src="<%= image%>" width="200px" height="200px"> 
    <br>
    <%= "price="%>
    <%= price%>
    <br>
    <%= "name="%>>
    <%= name%>
    
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