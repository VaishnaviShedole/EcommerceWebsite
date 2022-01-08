<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="com.flipkart.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<header>
<table border="0" width="100%" bgcolor="blue">
<tr>
<a href="Home.jsp"><button>Home</button></a>
<form action="PLP_page" method="post"> 
<th width="25%"><button name="category" value="Fashion">Fashion</button></th>
<th width="25%"><button name="category" value="Mobiles">Mobile</button></th>
<th width="25%"><button name="category" value="HomeAppliances">HomeAppliances</button></th>
<th width="25%"><button name="category" value="Electronics">Electronics</button></th>

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
String description=product.getDescription();
String category=product.getCategory();
String image=product.getImage();
%>

<form action="PDP_page" method="post">
<button type="submit" name="id" value="<%= id%>">
<img alt="no image" src="<%= image%>" width="200px" height="200px">
</button>

<br>
<%= "price="%>
<%= price%>
<br>
<%= "product="%>
<%= name%>
<br>
</form>
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