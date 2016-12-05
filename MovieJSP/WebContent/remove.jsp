<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <c:url value = "RemoveMyWatchListServlet" var="showURL">
   <c:param name="id" value= "${movies.id}"></c:param>
   
   </c:url>   
      <form method ="post" action="r">
      <input type ="hidden" name="id" value ="${movies.id}"/><br>
    
    
      <input type ="submit" value = "Add To My WatchList" >
      </form>
      
</body>
</html>