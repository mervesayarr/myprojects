<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Movie</title>
</head>
<body bgcolor="gray">
<table align=center border="3" bordercolor="FireBrick"  cellpadding="5" cellspacing="0">
 <tr>
 
 <th>Movie Name</th>
 <th>Imdb</th>
 <th>Genre</th>
 <th>Delete</th>
 </tr>
 <c:forEach items="${moviesList}" var="moviesList">


  <c:url value = "ShowDeleteMoviesServlet" var="showUrl">
 <c:param name="id" value= "${moviesList.id}"></c:param>
   
   </c:url>
   
   
   
  
   
 
 <tr>

 <td><font color="FireBrick"><b>${moviesList.movieName}</b></font></td>
 <td><font color="FireBrick">${moviesList.imdbRating}</font></td>
  <td><font color="FireBrick">${moviesList.genre}</font></td>
 
 <td><a href="${showUrl}"><img height=20 width=20 src="images/delete.png"></a></td>
 
 </tr>
 </c:forEach>
 </table>
</body>
</html>