<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add My Watchlist</title>
</head>
<body background="images/film.jpg">
 <h1>Show Movie</h1>

   <c:url value = "ShowMoviesServlet" var="showURL">
   <c:param name="id" value= "${movies.id}"></c:param>
   
   </c:url>   
     <fieldset>
    <font size=5 color="lightgray">Movie Name:  <c:out value="${movies.movieName}" /></font> 
      <br/>
    <font size=5 color="lightgray"> Imdb Rating: <c:out value="${movies.imdbRating}" /></font> 
      <br />
   
      <form method ="post" action="AddMyWatchListServlet">
      <input type ="hidden" name="id" value ="${movies.id}"/><br>
       <font size=5 color="lightgray"> Your Rating:
      <select name=review>
  <option value="1" >1</option>
  <option value="2" >2</option>
  <option value="3" >3</option>
  <option value="4" >4</option>
  <option value="5" >5</option>
  
</select>
   
    
      <input type ="submit" value = "Add To My WatchList" >
      </form>
      </font> 
      
      </fieldset>
</body>
</html>