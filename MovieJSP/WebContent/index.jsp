<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<style>
header {
    
    color:Crimson;
    text-align:center;
    padding:5px;	 
 
}
nav {
    line-height:45px;
    background-color:#eeeeee;
    float:top;
    padding:5px;
         
}
section {
    height:600px;
    width:600px;
    float:centre;
    padding:10px;	 	 
}
footer {
    background-color:gray;
    color:white;
    clear:both;
    text-align:center;
    padding:15px;	 	 
}

nav ul  {
    margin:0;padding:0;
}
nav ul li {
    display:inline; margin:5px;
}

nav ul:hover{
background-color:gray;
}
</style>
</head>
<body background="images/screen.jpg">

<header>
<h1><i>Welcome Merve Movie Site</i></h1>
<font size=5 color="white">Current User = ${sessionScope.customer.getName()}</font>
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 &nbsp&nbsp&nbsp&nbsp&nbsp  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    &nbsp&nbsp&nbsp&nbsp&nbsp
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 
</header>

<nav>
<ul>
  <li><a href="ListMoviesServlet"> <font size=5>Movies</font></a>
   <li><a href="SortMoviesServlet"><font size=5> The Best 10 Movies </font></a>
  <li><a href="ListComingSoonServlet"><font size=5> Coming Soon </font></a>
   

  <li><li><li><li><li><li><li><li><li><li><li><li><li><li><li><li><li><li><li>
  <li><li><li><li><li><li><li><li><li><li><li><li><li><li><li><li><li><li><li>
  <a href="register.jsp"> <font size=5>Register</font></a>
  <a href="login.jsp"><font size=5>Login</font></a><li>
  <a href="LogoutServlet"><font size=5>Logout</font></a>
</ul>
</nav>
 <c:if test="${sessionScope.customer != null && sessionScope.customer.getName() != 'admin' }">
 
 
	<ul>
     <li>
       &nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp
         &nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp
       <a href="ShowBaggServlet"  ><font size=5 color="lightgray" >My Watchlist</font> </a>
     <li>
      &nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp  &nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp
      <a href="EmptyBaggServlet"> <font size=5 color="lightgray">Empty Watchlist</font></a>
      </ul>
  
      
   </c:if>
   
   
 <c:if test="${sessionScope.customer.getName() == 'admin' }">
 <br><br><br>
 		 &nbsp&nbsp&nbsp&nbsp
      &nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp   &nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp&nbsp
       &nbsp&nbsp&nbsp&nbsp
       <a href="createmovies.jsp"> <font size=5 color="lightgray">Add New Movie</font></a>
       &nbsp&nbsp&nbsp&nbsp
       <a href="DeleteMovieServlet"> <font size=5 color="lightgray">Delete Movie</font></a>
      
   
    
       </c:if>
<section>

</section>


<footer>
<p>&copy; 2015 Merve Movies Site. All rights reserved.</p>
</footer>

</body>
</html>
