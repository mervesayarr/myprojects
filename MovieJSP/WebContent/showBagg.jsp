<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Watching List</title>
</head>
 <body background="images/my.jpg">
 <h1>My Watching List</h1>

   <c:forEach items="${bagLines}" var="line">
   
 
  <font size=5 color="FireBrick">Movie Name :<c:out value="${line.movies.movieName}" /></font><br>
   <font size=5 color="FireBrick">My Rating is :<c:out value="${line.review}" />  </font>
     
       <form method ="post" action="RemoveMyWatchListServlet">
      <input type ="hidden" name="id" value ="${line.movies.id}"/>
       <input type ="hidden" name="review" value ="${line.review}"/>
    	<input type ="submit" value = "Remove To My WatchList" >
      </form>
     
   </c:forEach>

</body>
</html>