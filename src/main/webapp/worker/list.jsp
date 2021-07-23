<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Web Worker Manager</title>

    <link type="text/css" rel="stylesheet" href="css/style.css" >
</head>
<body>
	<div id="header">
		<h2>Lista pracowników</h2>
	</div>
	<div id="nav">
		<a href="worker/add-worker.jsp">
			<div class="button">Dodaj pracownika</div>
		</a>
	</div>
	<div id="container">
		<table class="styled-table">
			<thead>
				<tr>
					<th>Imię</th>
					<th>Nazwisko</th>
					<th>Pensja</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="worker" items="${workers}">
					<tr>
						<td>${worker.firstName}</td>
						<td>${worker.lastName}</td>
						<td>${worker.salary}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
