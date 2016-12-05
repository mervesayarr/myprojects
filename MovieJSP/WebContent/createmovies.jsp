<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Movies</title>
<style>
fieldset { border:5px solid Maroon   }

legend {
  padding: 0.2em 0.5em;
  border:3px solid gray;
  
  color:white;
  font-size:35px;
  text-align:right;
  }
  </style>
</head>
</head>
<body bgcolor="RosyBrown ">
<br><br><br><br><br>
<fieldset>
   <form method="post" action="CreateMoviesServlet">
      Enter Movie Name:&nbsp&nbsp&nbsp <input type="text" name="movieName">
      <br>
      Enter Writer Name:&nbsp&nbsp&nbsp <input type="text" name="writerName">
      <br>
      Enter Director Name: <input type="text" name="directorName">
      <br>
      Enter imdb Rating:&nbsp&nbsp&nbsp&nbsp <input type="text" name="imdbRating">
      <br>
      Enter Genre:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="genre">
      <br><br>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
     &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
     &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
     &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
     &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

      <input type="submit" value="Add Movie ">

   </form>
</fieldset>
</body>
</html>