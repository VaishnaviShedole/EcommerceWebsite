<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.flipkart.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.PrintWriter"%>
   
   
   <%
   String msg=null;
   if(request.getAttribute("msg")!=null)
   
   {
   //PrintWriter pout=response.getWriter();
    msg=(String)request.getAttribute("msg");
   }
   else{
	   msg="";
   }
   %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
     
     <style>
        .demo
        {
         background-color:skyblue;
         padding:200px;
        }
        .dem
        {
        text-align:center;
        }
     </style>
     
<body>
<div class="demo">
<div class="dem">
<h3>Please login to continue!!</h3>
<form action="login" method="post">
email<input style="border-radius:25px" type="email" name="email"> <br>
password<input style="border-radius:25px" type="password" name="password"><br>
<input type="submit" value="submit">
 <a href=" Registration.jsp" >Register</a>
</form>
<%= msg %>
</div>
</div>
</body>

</html>