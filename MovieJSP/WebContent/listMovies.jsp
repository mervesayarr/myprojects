<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Movies</title>
</head>
<body background="images/movielist2.jpg">
 <h1 style="color:FireBrick "><i>List of Movies</i></h1>
 

   <c:forEach items="${moviesList}" var="movies">
   <c:url value = "ShowMoviesServlet" var="showUrl">
   <c:param name="id" value= "${movies.id}"></c:param>
   
   </c:url>
   
   <a href="${showUrl}">
  
      <font size=5 color="FireBrick"><c:out value="${movies.movieName}" /></font>
    
      </a>
      <br>
   </c:forEach>

</body>
</html>