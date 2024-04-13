<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film</title>
</head>
<body>
	<!-- asks user for the film id, send film id to mapped controller getFilm.do, accesses the film id request from database
 -->
	<form action="getFilm.do" method="POST">
		Film Id: <input type="text" name="filmId" /> <input type="submit"
			value="Show Film" />
	</form>
	<br>
	<br>
	<!-- 	item and var should match what is in line 25 of controller. Ahref must to a get request only to controller .do.
 -->
	<ol>
		<c:forEach items="${films}" var="film">
			<li><a href="getFilm.do?filmId=${film.id}">${film.title}</a></li>
		</c:forEach>
	</ol>

</body>
</html>