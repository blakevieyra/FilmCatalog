<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!-- <!-- dont forget to add the tag lib to access the EL
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film</title>
</head>
<body>

	<div>
		<!-- 		This is a null check so page doesnt break
 -->
		<c:choose>
			<c:when test="${! empty film}">
				<ul>
					<li>${film.title}</li>
					<li>${film.releaseYear}</li>
					<li>${film.rating}</li>
					<li>${film.description}</li>
					<li>${film.length}</li>
				</ul>
			</c:when>
			<c:otherwise>
				<h2>No film found</h2>
			</c:otherwise>
		</c:choose>
					<a class="btn" href="/">Home</a>
		
	</div>


</body>
</html>