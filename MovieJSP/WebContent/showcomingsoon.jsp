<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coming Soon</title>
</head>
<body background="images/showdetail.jpg">
<h1><i>Movie Details</i></h1>
<table border="3" bordercolor="white"  cellpadding="5" cellspacing="0">
 <tr>
 
 <th><font size=5 color="LightSteelBlue  " >Genre</th>
 <th><font size=5 color="LightSteelBlue  " >Detail</th>
 </tr>
   <c:url value = "ShowComingsoonServlet" var="showURL">
   <c:param name="id" value= "${movies.id}"></c:param>
   
   </c:url>   
   
    
     <tr>
      <td><font size=6 color="white"> <i> <c:out value="${movies.genre}" /></i></font></td>
       
     <td> <font size=6 color="white" > <i> <c:out value="${movies.detail}" /></i></font></td>
      <br />
      </tr>
      </table>
</body>
</html>