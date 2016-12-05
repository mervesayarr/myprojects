<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coming Soon</title>
</head>
<body bgcolor="Tan">

 
<img  height=100 width=750 src="images/comingsoon.JPG">

<br><br><br><br>
   <c:forEach items="${moviesList}" var="movies">
   <c:url value = "ShowComingsoonServlet" var="showUrl">
   <c:param name="id" value= "${movies.id}"></c:param>
   
   </c:url>
   <table>
  <tr>
     <td> <font size=5  ><b><c:out value="${movies.moviename}" /></b>&nbsp&nbsp&nbsp&nbsp</font></td>
     <td><font size=5 ><a href="${showUrl}"><i>Show Details</i></a></font></td>
      </tr>
      </table>
   </c:forEach>
</body>
</html>