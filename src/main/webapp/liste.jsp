<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h1>Liste des utilisateurs</h1>
		<c:set var="age" scope="session" value="${2}"/>
		<c:out value="${age}"/>
</body>
</html>