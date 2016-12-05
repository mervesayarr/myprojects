<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Best 10 Movies</title>
</head>
<body background="images/sort.jpg">
 
 <h1 style="color:FireBrick"><i>The Best 10 Movies</i></h1>

<table align="center" border="3" bordercolor="blue"  cellpadding="5" cellspacing="0">
<tr>
 
 <th>Movie Name</th>
 <th>IMDb</th>
 <th>Genre</th>
 </tr>

  <c:forEach items="${moviesList}" var="movies">
  
  <tr>
     <td><c:out value="${movies.movieName}" /></td>
     <td> <c:out value="${movies.imdbRating}" /></td>
     <td> <c:out value="${movies.genre}" /></td>
    </tr>
      
   </c:forEach>
</table>
</body>
</html>